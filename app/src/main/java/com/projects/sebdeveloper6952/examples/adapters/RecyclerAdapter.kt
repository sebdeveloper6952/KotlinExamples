package com.projects.sebdeveloper6952.examples.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.inflate
import kotlinx.android.synthetic.main.custom_list_item_2.view.*

class RecyclerAdapter(private val data: ArrayList<CustomItem>) :
        RecyclerView.Adapter<RecyclerAdapter.ItemHolder>() {

    private lateinit var listener: OnItemSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflatedView = parent.inflate(R.layout.custom_list_item_2, false)
        return ItemHolder(inflatedView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = data[position]
        holder.bindItem(item)
    }

    private fun deleteBtnClick(item: CustomItem) {
        data.remove(item)
        notifyDataSetChanged()
    }

    inner class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var item: CustomItem? = null

        init {
            v.setOnClickListener(this)
        }

        fun bindItem(item: CustomItem) {
            this.item = item
            view.rowImgView.setImageResource(item.imgId)
            view.rowTextTitle.text = item.name
            view.rowTextSubtitle.text = item.details
            view.rowBtnDelete.setOnClickListener { deleteBtnClick(item) }
        }

        override fun onClick(v: View) {

        }
    }

    interface OnItemSelected {
        fun onItemSelected(item: CustomItem)
    }
}