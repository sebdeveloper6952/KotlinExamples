package com.projects.sebdeveloper6952.examples.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import kotlinx.android.synthetic.main.custom_list_item_2.view.*

class ItemRecyclerViewAdapter(val data: ArrayList<CustomItem>):
    RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val convertView = layoutInflater.inflate(R.layout.custom_list_item_2, parent, false)
        val viewHolder = ItemHolder(convertView)
        viewHolder.rowImg = convertView.rowImgView
        viewHolder.rowTitle = convertView.rowTextTitle
        viewHolder.rowSubtitle = convertView.rowTextSubtitle
        viewHolder.btnDeleteItem = convertView.rowBtnDelete
        return viewHolder
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        with(holder) {
            rowImg?.setImageResource(data[position].imgId)
            rowTitle?.text = data[position].name
            rowSubtitle?.text = data[position].details
            btnDeleteItem?.setOnClickListener {
            }
        }
    }

    override fun getItemId(position: Int) = data[position].id.toLong()

    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        var rowImg: ImageView? = null
        var rowTitle: TextView? = null
        var rowSubtitle: TextView? = null
        var btnDeleteItem: Button? = null
    }
}