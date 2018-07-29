package ivanovd422.penaltyapp.mvp.MainScreen

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.R.id.toolbar
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense.DriverLicenseFragment
import ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate.RegistrationFragment
import ivanovd422.penaltyapp.mvp.OnBoardingScreen.OnBoardingActivity

class MainActivity : MvpAppCompatActivity(), MainScreenContract.View,
        AutoCertificateFragment.SkipFragment, AutoCertificateFragment.AutoCertificateData,
        RegistrationFragment.SkipFragment, RegistrationFragment.RegistrationData,
        DriverLicenseFragment.DriverLicenseData{


    @InjectPresenter
    lateinit var mPresenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
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
        Log.d("tag", "changeFragment")
        Log.d("tag", "Добавляем фрагмент ${f.javaClass.canonicalName}")
        val ft = supportFragmentManager.beginTransaction()
      /*  if (cleanStack) {
            clearBackStack()
        }*/
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.add(R.id.activity_base_content, f)
        ft.addToBackStack("TAG")
        ft.commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        Log.d("tag", "count - ${fragmentManager.backStackEntryCount}")
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
            Log.d("tag", "Должны вернуть фрагмент")
        } else {
            finish()
        }
    }

    override fun onSkipFragment() {
        mPresenter.viewState.addNextFragment()
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
                Log.d("tag", "Переходим на walkthrough")
                Log.d("tag", "1 ${mPresenter.autoCertificateData}")
                Log.d("tag", "1 ${mPresenter.registrationCertificateData}")
                Log.d("tag", "1 ${mPresenter.driverLicenseData}")

                val intent = Intent(this, OnBoardingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

    }

    override fun passCertificateData(data: String) {
        mPresenter.autoCertificateData = data
        mPresenter.viewState.addNextFragment()
    }

    override fun passRegistrationData(data: String) {
        mPresenter.registrationCertificateData = data
        mPresenter.viewState.addNextFragment()
    }

    override fun passDriverLicenseData(data: String) {
        mPresenter.driverLicenseData = data
        mPresenter.viewState.addNextFragment()
    }
}
