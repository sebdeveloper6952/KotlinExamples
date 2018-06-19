package com.projects.sebdeveloper6952.examples.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.adapters.CustomItemRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_item_list.view.*

class ItemListFragment : Fragment() {

    private var listener: OnItemListFragmentInteractionListener? = null
    private val items = arrayListOf(
            CustomItem(1, "item1",
                    "These are item1 details", R.drawable.ic_android_black_24dp),
            CustomItem(2, "item2",
                    "These are item2 details", R.drawable.ic_announcement_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp))

    companion object {
        fun newInstance(): ItemListFragment {
            return ItemListFragment().apply {

            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnItemListFragmentInteractionListener) listener = context
        else throw ClassCastException(context.toString()
                + " must implement OnItemListFragmentInteractionListener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_item_list, container, false)
        val recyclerView = layout.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomItemRecyclerAdapter(items, listener)
        return layout
    }

    interface OnItemListFragmentInteractionListener {
        fun onItemListFragmentInteraction(item: CustomItem?)
    }
}
