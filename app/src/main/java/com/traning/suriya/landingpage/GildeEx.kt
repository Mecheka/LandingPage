package com.traning.suriya.landingpage

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadResourceCircle(resId: Int) {
    Glide.with(this)
        .load(resId)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}