package com.mtp.kotlin.demokotlin.di

import android.app.Application
import android.content.Context
import com.mtp.kotlin.demokotlin.mvp.models.view.BaseView
import dagger.Module
import dagger.Provides

/**
 * Created by Sofien on 27/05/2018.
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object ContextModule {
    /**
     * Provides the Context
     * @param baseView the BaseView used to provides the context
     * @return the Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    /**
     * Provides the Application Context
     * @param context Context in which the application is running
     * @return the Application Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}