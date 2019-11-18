package com.cvdevelopers.poweradapterdemo.di.modules;

import com.cvdevelopers.poweradapterdemo.userlist.renderer.UserOneRenderer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

import com.cvdevelopers.poweradapterdemo.userlist.renderer.UserOneRenderer.Companion.RENDER_KEY
import com.cvdevelopers.powerrecycleradapter.item.ItemRenderer
import com.cvdevelopers.powerrecycleradapter.item.RecyclerItem
import com.cvdevelopers.powerrecycleradapter.item.RenderKey

@Module
abstract class RecyclerItemRenderModule {

    @Binds
    @IntoMap
    @RenderKey(RENDER_KEY)
    internal abstract fun bindRenderer(template: UserOneRenderer): ItemRenderer<out RecyclerItem>


}
