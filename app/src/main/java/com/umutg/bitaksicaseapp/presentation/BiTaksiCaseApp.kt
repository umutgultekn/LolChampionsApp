package com.umutg.bitaksicaseapp.presentation

import android.app.Application
import com.umutg.bitaksicaseapp.common.Constants.TAG
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree


@HiltAndroidApp
class BiTaksiCaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(object : DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                super.log(priority, "$TAG$tag", message, t)
            }

            override fun createStackElementTag(element: StackTraceElement): String {
                return String.format(
                    "%s:%s",
                    element.methodName,
                    super.createStackElementTag(element)
                )
            }
        })
    }
}