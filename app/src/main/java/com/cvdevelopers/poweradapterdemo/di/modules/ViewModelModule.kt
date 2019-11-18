package com.cvdevelopers.poweradapterdemo.di.modules

import androidx.lifecycle.ViewModel
import com.cvdevelopers.poweradapterdemo.di.vm.ViewModelKey
import com.cvdevelopers.poweradapterdemo.userlist.UserListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( UserListViewModel::class )
    abstract fun bindUserListViewModel( userListViewModel: UserListViewModel ): ViewModel
}