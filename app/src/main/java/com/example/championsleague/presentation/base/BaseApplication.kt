package com.example.championsleague.presentation.base

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class BaseApplication: MultiDexApplication() {

    companion object {
        lateinit var instance: BaseApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}