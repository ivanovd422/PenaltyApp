package ivanovd422.penaltyapp.mvp.DataScreen

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ivanovd422.penaltyapp.R
import kotlinx.android.synthetic.main.data_layout.*
import javax.inject.Inject

class DataActivity: MvpAppCompatActivity(),  DataContract.View,
        HasActivityInjector {

    @Inject
    @InjectPresenter
    lateinit var presenter: DataPresenter

    @ProvidePresenter
    fun providePresenter(): DataPresenter  {
        return presenter
    }


    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_layout)
    }

    override fun showAutoCertificate(data: String) {
        auto_certificate_value.text = data
    }

    override fun showRegistrationCertificate(data: String) {
        auto_registration_value.text = data
    }

    override fun showDriverLicense(data: String) {
        driver_license_value.text = data
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
