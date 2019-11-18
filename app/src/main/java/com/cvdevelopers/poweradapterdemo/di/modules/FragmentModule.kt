package com.cvdevelopers.poweradapterdemo.di.modules

import com.cvdevelopers.poweradapterdemo.userlist.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract fun contributeUserFragment(): UserFragment
}