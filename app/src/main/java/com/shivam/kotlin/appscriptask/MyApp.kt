package com.shivam.kotlin.appscriptask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Application class to initialiaze dagger hilt

@HiltAndroidApp
class MyApp: Application()

/*
* 1. DataBinding for binding the views with the classes
* 2. Dagger Hilt for dependency injection
* 3. RoomDB for local database
* 4. Navigation Graph for navigations
* 5. SafeArgs for passing data between views
* 6. ViewModels
* 7. Followed MVVM Architecture Pattern
*
* */