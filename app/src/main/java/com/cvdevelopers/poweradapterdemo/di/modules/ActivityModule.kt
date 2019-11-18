package com.cvdevelopers.poweradapterdemo.di.modules

import com.cvdevelopers.poweradapterdemo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class, RecyclerItemRenderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}