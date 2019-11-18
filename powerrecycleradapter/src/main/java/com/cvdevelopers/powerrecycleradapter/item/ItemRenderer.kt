package com.cvdevelopers.powerrecycleradapter.item

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface ItemRenderer <T: RecyclerItem> {

    @LayoutRes
    fun getLayoutId(): Int

    fun createView(parent: ViewGroup): View

    fun render(itemView: View, item: T)

    fun isSelected(isSelected: Boolean, itemView: View) {}
}