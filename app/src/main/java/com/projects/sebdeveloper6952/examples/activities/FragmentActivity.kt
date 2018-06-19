package com.projects.sebdeveloper6952.examples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.projects.sebdeveloper6952.examples.CustomItem
import com.projects.sebdeveloper6952.examples.fragments.ItemDetailsFragment
import com.projects.sebdeveloper6952.examples.fragments.ItemListFragment
import com.projects.sebdeveloper6952.examples.R

class FragmentActivity : AppCompatActivity(),
        ItemListFragment.OnItemListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        // check for saved state before adding a new fragment
        if(savedInstanceState == null) {
            // add recycler list fragment
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.root_layout, ItemListFragment.newInstance(), "itemList")
                    .commit()
        }
    }

    override fun onItemListFragmentInteraction(item: CustomItem?) {
        // replace list fragment with details of item fragment
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_layout, ItemDetailsFragment.newInstance(item), "itemDetails")
                .addToBackStack(null)
                .commit()
    }
}
