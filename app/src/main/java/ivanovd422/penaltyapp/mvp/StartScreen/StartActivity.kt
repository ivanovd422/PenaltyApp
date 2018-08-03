package ivanovd422.penaltyapp.mvp.StartScreen

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.Utils.Constants.WIZARD
import ivanovd422.penaltyapp.mvp.DataScreen.DataActivity
import ivanovd422.penaltyapp.mvp.MainScreen.MainActivity
import javax.inject.Inject

class StartActivity: AppCompatActivity(), HasActivityInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity_layout)

        val wizard = sharedPref.getBoolean(WIZARD, false)

        if (wizard){
            intent = Intent(this, DataActivity::class.java)
        } else{
            intent = Intent(this, MainActivity::class.java)
        }

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
