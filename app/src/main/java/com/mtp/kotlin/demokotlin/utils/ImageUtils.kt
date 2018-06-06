package com.mtp.kotlin.demokotlin.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Sofien on 04/06/2018.
 */
class ImageUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(v: ImageView, imgUrl: String) {
            Glide.with(v.context).load(imgUrl).into(v)
        }
    }
}