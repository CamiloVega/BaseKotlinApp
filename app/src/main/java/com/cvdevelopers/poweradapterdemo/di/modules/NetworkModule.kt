package com.cvdevelopers.poweradapterdemo.di.modules

import com.cvdevelopers.poweradapterdemo.api.fetchusers.IUserEndpoint
import com.cvdevelopers.poweradapterdemo.api.mock.MockUserEndpointImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun providesUserFetch(userFetchImpl: MockUserEndpointImpl): IUserEndpoint
}