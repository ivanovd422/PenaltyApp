package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense


import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter

@InjectViewState
class DriverLicensePresenter: BasePresenter<DriverLicenseContract.View>(), DriverLicenseContract.Presenter {

    var CERTIFICATE_CONFRIMED : Boolean = false

    override fun checkData(data: String) {
        if (CERTIFICATE_CONFRIMED){
            viewState.passData(data)
        }
    }
}

