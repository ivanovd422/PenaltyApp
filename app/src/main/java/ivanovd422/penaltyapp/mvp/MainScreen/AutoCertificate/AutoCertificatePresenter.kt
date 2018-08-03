package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import javax.inject.Inject

@InjectViewState
class AutoCertificatePresenter @Inject constructor(val interactor: AutoCertificateInteractor) :
        BasePresenter<AutoCertificateContract.View>(),
        AutoCertificateContract.Presenter {

     var confirmedDataFlag: Boolean = false
    lateinit var autoCertificateData: String

    override fun isDataValid() {
        if (confirmedDataFlag){
            viewState.passData(autoCertificateData)
        }
    }

    override fun enteredText(data: String) {
        if (interactor.checkData(data)){
            confirmedDataFlag = true
            autoCertificateData = data
        } else if (data.length > 8){
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
