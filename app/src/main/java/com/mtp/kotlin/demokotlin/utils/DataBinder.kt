package com.mtp.kotlin.demokotlin.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mtp.kotlin.demokotlin.RecyclerAdapter

/**
 * Created by Sofien on 03/06/2018.
 */
class DataBinder {
    /**
     * Sets an adapter to a RecyclerView (to be used in view with one RecyclerView)
     * @param view the RecyclerView on which to set the adapter
     * @param adapter the adapter to set to the RecyclerView
     */
    companion object {
        @JvmStatic
        @BindingAdapter("adapter")
        fun setAdapter(view: RecyclerView, adapter: RecyclerAdapter?) {
            view.adapter = adapter
        }
    }
}