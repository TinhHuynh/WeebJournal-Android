package com.lenz.oliver.movieswithkotlin.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import harrycoder.github.com.weebjournal.WjApplication
import harrycoder.github.com.weebjournal.di.ActivityBindingModule
import harrycoder.github.com.weebjournal.di.RepositoryModule
import harrycoder.github.com.weebjournal.di.ViewModelModule
import javax.inject.Singleton


/**
 * The [ApplicationComponent] combines all modules.
 *
 * The dagger binding is inspired from this repo:
 * https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    RepositoryModule::class,
    ActivityBindingModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: WjApplication)
}