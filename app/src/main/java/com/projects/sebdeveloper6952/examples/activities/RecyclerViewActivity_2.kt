package com.projects.sebdeveloper6952.examples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.adapters.ItemRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_2.*

class RecyclerViewActivity_2 : AppCompatActivity() {

    private val items = arrayListOf(
            CustomItem(1, "item1",
                    "These are item1 details", R.drawable.ic_android_black_24dp),
            CustomItem(2, "item2",
                    "These are item2 details", R.drawable.ic_announcement_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_announcement_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_android_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_2)

        // setear adapter de listView
        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity_2)
        recyclerView.adapter = ItemRecyclerViewAdapter(items)
    }
}
