package com.traning.suriya.landingpage.landing

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.traning.suriya.landingpage.R

class ItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildLayoutPosition(view)
        val listSize = parent.adapter?.itemCount
        when (itemPosition) {
            0 -> {
                outRect.left = view.context.resources.getDimension(R.dimen.margin_16).toInt()
            }
            listSize?.minus(1) -> {
                outRect.right = view.context.resources.getDimension(R.dimen.margin_16).toInt()
            }
            else -> {

            }
        }
    }
}