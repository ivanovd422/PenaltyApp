package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense


import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import javax.inject.Inject

@InjectViewState
class DriverLicensePresenter @Inject constructor(val interactor: DriverLicenseInteractor):
        BasePresenter<DriverLicenseContract.View>(),
        DriverLicenseContract.Presenter {

    var confirmedDataFlag: Boolean = false
    lateinit var driverLicenseData: String

    override fun isDataValid() {
        if (confirmedDataFlag){
            viewState.passData(driverLicenseData)
        }
    }

    override fun enteredText(data: String) {
        if (interactor.checkData(data)){
            confirmedDataFlag = true
            driverLicenseData = data
        } else if (data.length > 10){
            viewState.showTextError()
        }
    }


    override fun onDialogPositiveButton() {
        viewState.dismissDialog()
        viewState.onSkipStage()
    }

    override fun onDialogNegativeButton() {
        viewState.dismissDialog()
    }

    override fun onDialogDismiss() {
        viewState.dismissDialog()
    }
}

