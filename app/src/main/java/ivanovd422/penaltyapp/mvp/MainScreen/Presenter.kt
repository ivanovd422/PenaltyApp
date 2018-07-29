package ivanovd422.penaltyapp.mvp.MainScreen

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment

@InjectViewState
class Presenter : BasePresenter<MainScreenContract.View>(), MainScreenContract.Presenter{

    lateinit var autoCertificateData : String
    lateinit var driverLicenseData : String
    lateinit var registrationCertificateData : String

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d("tag", "onFirstViewAttach")
        viewState.changeFragment(AutoCertificateFragment())
    }


    override fun attachView(view: MainScreenContract.View?) {
        super.attachView(view)
    }


}
