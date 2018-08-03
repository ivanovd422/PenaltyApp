package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter @Inject constructor(val interactor: RegistrationInteractor): BasePresenter<RegistrationContract.View>(), RegistrationContract.Presenter {

    var confirmedDataFlag: Boolean = false
    lateinit var registrationData: String

    override fun isDataValid() {
        if (confirmedDataFlag){
            viewState.passData(registrationData)
        }
    }

    override fun enteredText(data: String) {
        if (interactor.checkData(data)){
            confirmedDataFlag = true
            registrationData = data
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

