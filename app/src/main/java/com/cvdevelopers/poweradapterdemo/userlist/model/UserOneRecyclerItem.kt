package com.cvdevelopers.poweradapterdemo.userlist.model

import com.cvdevelopers.poweradapterdemo.userlist.renderer.UserOneRenderer.Companion.RENDER_KEY
import com.cvdevelopers.powerrecycleradapter.item.RecyclerItem

//The Id must be Unique!
data class UserOneRecyclerItem(val id: Int, val name: String) : RecyclerItem {
    override fun getId(): Long =
        id.toLong()

    override fun getRendererKey(): String =
        RENDER_KEY

    override fun getItemsHash(): Int =
        hashCode()
}