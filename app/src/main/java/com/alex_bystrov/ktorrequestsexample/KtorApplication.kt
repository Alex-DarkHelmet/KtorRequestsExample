package com.alex_bystrov.ktorrequestsexample

import android.app.Application
import com.alex_bystrov.ktorrequestsexample.core.coreModule
import com.alex_bystrov.ktorrequestsexample.features.characters.di.networkModule
import com.alex_bystrov.ktorrequestsexample.features.characters.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KtorApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@KtorApplication)

            modules(
                coreModule,
                networkModule,
                viewModelModule
            )
        }
    }
}