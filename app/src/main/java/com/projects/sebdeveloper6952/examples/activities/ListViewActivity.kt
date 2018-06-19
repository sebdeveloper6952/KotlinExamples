package com.projects.sebdeveloper6952.examples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.adapters.CustomItemAdapter

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val items = arrayListOf(
            CustomItem(1, "item1",
                    "These are item1 details", R.drawable.ic_android_black_24dp),
            CustomItem(2, "item2",
                    "These are item2 details", R.drawable.ic_announcement_black_24dp),
            CustomItem(3, "item3",
                    "These are item3 details", R.drawable.ic_assignment_ind_black_24dp))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listView = findViewById(R.id.listView_recipes)
        val adapter = CustomItemAdapter(applicationContext, items)
        listView.adapter = adapter
    }
}
