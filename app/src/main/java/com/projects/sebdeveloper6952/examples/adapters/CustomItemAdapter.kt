package com.projects.sebdeveloper6952.examples.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import kotlinx.android.synthetic.main.custom_list_item_2.view.*

class CustomItemAdapter(context: Context,
                        private val data: ArrayList<CustomItem>) : BaseAdapter() {

    private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row: View
        val holder: ViewHolder
        if(convertView == null) {
            row = inflater.inflate(R.layout.custom_list_item_2, parent, false)
            holder = ViewHolder()
            holder.rowImgView = row.rowImgView
            holder.rowTextTitle = row.rowTextTitle
            holder.rowTextSubtitle = row.rowTextSubtitle
            holder.rowBtnDelete = row.rowBtnDelete
            row.tag = holder
        }
        else {
            row = convertView
            holder = convertView.tag as ViewHolder
        }
        val rowImgView = holder.rowImgView
        val rowTextTitle = holder.rowTextTitle
        val rowTextSubtitle = holder.rowTextSubtitle
        val rowBtnDelete = holder.rowBtnDelete
        rowImgView.setImageResource(data[position].imgId)
        rowTextTitle.text = data[position].name
        rowTextSubtitle.text = data[position].details
        rowBtnDelete.setOnClickListener{ btnDeleteClick(position) }
        return row
    }

    override fun getItem(position: Int) = data[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = data.size

    private fun btnDeleteClick(index: Int) {
        data.removeAt(index)
        notifyDataSetChanged()
    }

    private class ViewHolder {
        lateinit var rowImgView: ImageView
        lateinit var rowTextTitle: TextView
        lateinit var rowTextSubtitle: TextView
        lateinit var rowBtnDelete: Button
    }
}