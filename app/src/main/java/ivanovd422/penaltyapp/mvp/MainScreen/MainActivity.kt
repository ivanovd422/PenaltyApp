package ivanovd422.penaltyapp.mvp.MainScreen

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.R.id.toolbar
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense.DriverLicenseFragment
import ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate.RegistrationFragment
import ivanovd422.penaltyapp.mvp.OnBoardingScreen.OnBoardingActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainScreenContract.View,
        AutoCertificateFragment.SkipFragment, AutoCertificateFragment.AutoCertificateData,
        RegistrationFragment.SkipFragment, RegistrationFragment.RegistrationData,
        DriverLicenseFragment.DriverLicenseData, DriverLicenseFragment.SkipFragment,
        HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector : DispatchingAndroidInjector<Fragment>

    @Inject
    @InjectPresenter
    lateinit var presenter: Presenter

    @ProvidePresenter
    fun providePresenter(): Presenter  {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    override fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun changeFragment(f: Fragment, cleanStack: Boolean) {
        val ft = supportFragmentManager.beginTransaction()

        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.add(R.id.activity_base_content, f)
        ft.addToBackStack("TAG")
        ft.commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    override fun onSkipFragment() {
        presenter.fragmentSkipped()
    }

    override fun addNextFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.activity_base_content)

        when (fragment) {
            is AutoCertificateFragment -> supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_base_content, RegistrationFragment())
                    .addToBackStack("TAG")
                    .commit()
            is RegistrationFragment -> supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_base_content, DriverLicenseFragment())
                    .addToBackStack("TAG")
                    .commit()
            else -> {

                presenter.saveData()

                val intent = Intent(this, OnBoardingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

    }

    override fun passCertificateData(data: String) {
        presenter.autoCertificateData = data
        presenter.fragmentSkipped()
    }

    override fun passRegistrationData(data: String) {
        presenter.registrationCertificateData = data
        presenter.fragmentSkipped()
    }

    override fun passDriverLicenseData(data: String) {
        presenter.driverLicenseData = data
        presenter.fragmentSkipped()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}
