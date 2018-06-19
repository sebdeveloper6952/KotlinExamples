package com.projects.sebdeveloper6952.examples

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ImageView.loadUrl(url: String) {
    Picasso.get().load(url).into(this)
}

fun ImageView.loadUrl(url: String, width: Int, height: Int) {
    Picasso.get().load(url).resize(width, height).into(this)
}