package com.projects.sebdeveloper6952.examples.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import kotlinx.android.synthetic.main.fragment_item_details.view.*
import java.io.Serializable

class ItemDetailsFragment : Fragment() {

    companion object {
        fun newInstance(item: CustomItem?): ItemDetailsFragment {
            return ItemDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("item", item as Serializable)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_item_details, container, false)
        val item = arguments?.getSerializable("item") as CustomItem
        layout.imageView_itemImg.setImageResource(item.imgId)
        layout.txtView_name.text = item.name
        layout.txtView_details.text = item.details
        return layout
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
}
