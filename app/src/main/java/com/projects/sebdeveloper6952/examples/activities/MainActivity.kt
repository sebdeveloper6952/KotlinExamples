package com.projects.sebdeveloper6952.examples.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.projects.sebdeveloper6952.examples.R
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnListViewClick(v:View) {
        startActivity<ListViewActivity>()
    }

    fun btnRecyclerViewClick(v: View) {
        startActivity<RecyclerViewActivity>()
    }

    fun btnFragmentActivityClick(v: View) {
        startActivity<FragmentActivity>()
    }

    fun btnRoomActivity(v: View) {
        startActivity<RoomActivity>()
    }
}
