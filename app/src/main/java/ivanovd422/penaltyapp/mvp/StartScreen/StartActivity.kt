package ivanovd422.penaltyapp.mvp.StartScreen

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.Utils.Constants.Companion.SHARED_PREFERENCES_SETTINGS
import javax.inject.Inject

class StartActivity: AppCompatActivity(), HasActivityInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

/*    @Inject
    lateinit var sharedPref : SharedPreferences*/

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity_layout)

//        var data = sharedPref.getString(SHARED_PREFERENCES_SETTINGS, "")
//        Log.d("tag", "data - $data")
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
