package com.coco.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Mvvm : Application()
// This is the entry point of the application.
// It is annotated with @HiltAndroidApp, which triggers Hilt's code generation.
