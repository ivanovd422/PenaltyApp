package ivanovd422.penaltyapp.mvp.MainScreen

import android.content.SharedPreferences
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.Utils.Constants.Companion.AUTO_CERTIFICATE
import ivanovd422.penaltyapp.Utils.Constants.Companion.AUTO_REGISTRATION
import ivanovd422.penaltyapp.Utils.Constants.Companion.DRIVER_LICENSE
import ivanovd422.penaltyapp.Utils.Constants.Companion.WIZARD
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import javax.inject.Inject

@InjectViewState
class Presenter(var mPreferences: SharedPreferences) : BasePresenter<MainScreenContract.View>(),
        MainScreenContract.Presenter{

     var autoCertificateData : String = ""
     var registrationCertificateData : String = ""
     var driverLicenseData : String = ""


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.changeFragment(AutoCertificateFragment())
    }


    override fun attachView(view: MainScreenContract.View?) {
        super.attachView(view)
    }

    override fun saveData() {
        if (!autoCertificateData.equals("")){
            mPreferences.edit().putString(AUTO_CERTIFICATE, autoCertificateData).apply()
        }
        if (!registrationCertificateData.equals("")){
            mPreferences.edit().putString(AUTO_REGISTRATION, registrationCertificateData).apply()
        }
        if (!driverLicenseData.equals("")){
            mPreferences.edit().putString(DRIVER_LICENSE, driverLicenseData).apply()
        }

        if (!autoCertificateData.equals("") and !driverLicenseData.equals("") and !registrationCertificateData.equals("")){
            mPreferences.edit().putBoolean(WIZARD, true).apply()
        }
    }
}
