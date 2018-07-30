package ivanovd422.penaltyapp.mvp.DataScreen

import android.content.SharedPreferences
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.Utils.Constants.Companion.AUTO_CERTIFICATE
import ivanovd422.penaltyapp.Utils.Constants.Companion.AUTO_REGISTRATION
import ivanovd422.penaltyapp.Utils.Constants.Companion.DRIVER_LICENSE
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import javax.inject.Inject


@InjectViewState
class DataPresenter @Inject constructor(val sharedPreferences: SharedPreferences) :
        BasePresenter<DataContract.View>(), DataContract.Presenter{

    lateinit var autoCertificateData : String
    lateinit var autoRegistrationCertificate : String
    lateinit var autoDriverLicense : String

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        autoCertificateData = sharedPreferences.getString(AUTO_CERTIFICATE, "")
        autoRegistrationCertificate = sharedPreferences.getString(AUTO_REGISTRATION, "")
        autoDriverLicense = sharedPreferences.getString(DRIVER_LICENSE, "")
    }

    override fun attachView(view: DataContract.View?) {
        super.attachView(view)

        viewState.showAutoCertificate(autoCertificateData)
        viewState.showRegistrationCertificate(autoRegistrationCertificate)
        viewState.showDriverLicense(autoDriverLicense)

    }
}
