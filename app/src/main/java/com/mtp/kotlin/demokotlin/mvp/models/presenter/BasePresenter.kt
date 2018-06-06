package com.mtp.kotlin.demokotlin.mvp.models.presenter

import android.content.Context
import com.mtp.kotlin.demokotlin.di.AppComponent
import com.mtp.kotlin.demokotlin.di.ContextModule
import com.mtp.kotlin.demokotlin.di.DaggerAppComponent
import com.mtp.kotlin.demokotlin.di.NetworkModule
import com.mtp.kotlin.demokotlin.mvp.models.view.BaseView
import com.mtp.kotlin.demokotlin.mvp.models.view.PostView

/**
 * Created by Sofien on 27/05/2018.
 */
abstract class BasePresenter<out V : BaseView>(val view: V) {

    private val injector: AppComponent = DaggerAppComponent
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onAttachView(context: Context){}

    open fun onDetachView(){}

    private fun inject() {
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}