package com.cvdevelopers.poweradapterdemo.userlist.renderer;

import android.view.View
import android.view.ViewGroup
import com.cvdevelopers.poweradapterdemo.R
import com.cvdevelopers.poweradapterdemo.userlist.model.UserOneRecyclerItem
import com.cvdevelopers.poweradapterdemo.util.inflate
import com.cvdevelopers.powerrecycleradapter.item.ItemRenderer
import kotlinx.android.synthetic.main.user_one_item.view.*
import javax.inject.Inject

class UserOneRenderer @Inject constructor() : ItemRenderer<UserOneRecyclerItem> {

    override fun getLayoutId(): Int =
        R.layout.user_one_item

    override fun createView(parent: ViewGroup): View =
        parent.inflate(getLayoutId(), false) //this is a kotlin extension

    override fun render(itemView: View, item: UserOneRecyclerItem) =
        bind(itemView, item)

    private fun bind(view: View, data: UserOneRecyclerItem) {
        view.text_view.text = data.name
        //Populate the data in your view
    }

    companion object {
        const val RENDER_KEY = "UserOneRenderer"
    }
}