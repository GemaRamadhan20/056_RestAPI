package com.example.kontak

import android.app.Application
import com.example.kontak.repository.AppContainer
import com.example.kontak.repository.KontakContainer

class KontakApplication : Application() {
    /** AppContainer Instance Used By the rest of classes */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}