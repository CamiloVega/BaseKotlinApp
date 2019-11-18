package com.cvdevelopers.poweradapterdemo.di.components

import android.app.Application
import com.cvdevelopers.poweradapterdemo.DemoApplication
import com.cvdevelopers.poweradapterdemo.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidInjectionModule::class, ActivityModule::class, ApiModule::class, NetworkModule::class, ViewModelModule::class]
)
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: DemoApplication)

}
