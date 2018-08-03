package ivanovd422.penaltyapp.mvp.MainScreen

import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import javax.inject.Inject

@InjectViewState
class Presenter @Inject constructor(private val interactor: MainInteractor):
        BasePresenter<MainScreenContract.View>(), MainScreenContract.Presenter{

     var autoCertificateData : String = ""
     var registrationCertificateData : String = ""
     var driverLicenseData : String = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.changeFragment(AutoCertificateFragment())
    }


    override fun saveData() {
        interactor.insertData(autoCertificateData, registrationCertificateData, driverLicenseData)
    }

    override fun fragmentSkipped() {
        viewState.addNextFragment()
    }
}
