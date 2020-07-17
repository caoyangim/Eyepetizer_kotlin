package com.cy.eyepetizer

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.cy.applibrary.global.Eyepetizer

class EyepetizerApp :Application(){
    override fun onCreate() {
        super.onCreate()
        Eyepetizer.init(this)
            .withApiHost("http://baobab.kaiyanapp.com/")
            .configure()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}