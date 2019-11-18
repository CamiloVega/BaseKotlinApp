package com.cvdevelopers.poweradapterdemo.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesGson() = GsonBuilder().create()

}