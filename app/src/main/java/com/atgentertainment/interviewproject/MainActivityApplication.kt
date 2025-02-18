package com.atgentertainment.interviewproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainActivityApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}