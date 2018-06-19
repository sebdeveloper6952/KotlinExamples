package com.projects.sebdeveloper6952.examples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.adapters.RecyclerAdapter
import com.projects.sebdeveloper6952.examples.toast
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    private val items = arrayListOf(
            CustomItem(1, "item1",
                    "These are item1 details", R.drawable.ic_android_black_24dp),
            CustomItem(2, "item2",
                    "These are item2 details", R.drawable.ic_announcement_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(items)
        recyclerView.adapter = adapter
        setRecyclerViewOnScrollListener()
    }

    private fun setRecyclerViewOnScrollListener() {
        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                applicationContext.toast("onScrollStateChanged!")
            }
        })
    }
}
