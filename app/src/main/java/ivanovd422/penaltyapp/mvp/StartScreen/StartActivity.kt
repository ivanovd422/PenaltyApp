package ivanovd422.penaltyapp.mvp.StartScreen

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.Utils.Constants.Companion.AUTO_CERTIFICATE
import ivanovd422.penaltyapp.Utils.Constants.Companion.SHARED_PREFERENCES_SETTINGS
import ivanovd422.penaltyapp.Utils.Constants.Companion.WIZARD
import ivanovd422.penaltyapp.mvp.DataScreen.DataActivity
import ivanovd422.penaltyapp.mvp.MainScreen.MainActivity
import ivanovd422.penaltyapp.mvp.OnBoardingScreen.OnBoardingActivity
import javax.inject.Inject

class StartActivity: AppCompatActivity(), HasActivityInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var sharedPref : SharedPreferences

    lateinit var mIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity_layout)

        val wizard = sharedPref.getBoolean(WIZARD, false)

        if (wizard){
            mIntent = Intent(this, DataActivity::class.java)
        } else{
            mIntent = Intent(this, MainActivity::class.java)
        }

        mIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(mIntent)
        finish()

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
