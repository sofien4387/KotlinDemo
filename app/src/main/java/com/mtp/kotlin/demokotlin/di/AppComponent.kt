package com.mtp.kotlin.demokotlin.di

import com.mtp.kotlin.demokotlin.mvp.models.presenter.PostPresenter
import com.mtp.kotlin.demokotlin.mvp.models.view.BaseView
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Sofien on 03/06/2018.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface AppComponent {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}