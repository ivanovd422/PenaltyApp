package ivanovd422.penaltyapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ivanovd422.penaltyapp.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(),HasActivityInjector {
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
