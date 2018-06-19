package com.projects.sebdeveloper6952.examples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.projects.sebdeveloper6952.examples.CustomDatabase
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.loadUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_room.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class RoomActivity : AppCompatActivity() {

    private var itemsDb: CustomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        itemsDb = CustomDatabase.getInstance(this)

        // load image from url
        // https://img.vavel.com/24129604-935810009909315-4603081000295447449-n-484616709.png
        imgView_logo.loadUrl("https://img.vavel.com/24129604-935810009909315-4603081000295447449-n-484616709.png")
//        imgView_logo.loadUrl("https://img.vavel.com/24129604-935810009909315-4603081000295447449-n-484616709.png",
//                200, 200)
    }

    fun btnInsert(v: View) {
        val id = editText_id.text.toString()
        val name = editText_name.text.toString()
        val details = editText_details.text.toString()
        if(id == "" || name == "" || details == "") {
            toast("Wrong item information.")
            return
        }
        doAsync {
            itemsDb?.customItemDao()?.insert(CustomItem(
                    id.toInt(),
                    name,
                    details,
                    R.drawable.ic_announcement_black_24dp))
        }
    }

    fun btnGet(v: View) {
        val id = editText_id.text.toString().toInt()
        doAsync {
            val items = itemsDb?.customItemDao()?.getById(id)
            uiThread{
                if(items?.size!! > 0) {
                    val item = items[0]
                    textView_name.text = item.name
                    textView_details.text = item.details
                }
            }
        }
    }
}
