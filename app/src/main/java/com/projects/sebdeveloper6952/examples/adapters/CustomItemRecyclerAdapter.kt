package com.projects.sebdeveloper6952.examples.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.fragments.ItemListFragment
import com.projects.sebdeveloper6952.examples.R
import kotlinx.android.synthetic.main.custom_list_item_2.view.*

class CustomItemRecyclerAdapter(
        private val data: ArrayList<CustomItem>,
        private val listener: ItemListFragment.OnItemListFragmentInteractionListener?)
    : RecyclerView.Adapter<CustomItemRecyclerAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as CustomItem
            listener?.onItemListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_list_item_2, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.rowImg.setImageResource(item.imgId)
        holder.rowTitle.text = item.name
        holder.rowSubtitle.text = item.details
        with(holder.view) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val rowImg: ImageView = view.rowImgView
        val rowTitle: TextView = view.rowTextTitle
        val rowSubtitle: TextView = view.rowTextSubtitle
        val btnDeleteItem: Button = view.rowBtnDelete
    }
}