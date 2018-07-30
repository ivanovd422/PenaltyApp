package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter

@InjectViewState
class AutoCertificatePresenter : BasePresenter<AutoCertificateContract.View>(),
        AutoCertificateContract.Presenter {

     var CERTIFICATE_CONFRIMED : Boolean = false

    override fun checkData(data: String) {
        if (CERTIFICATE_CONFRIMED){
            viewState.passData(data)
        }
    }


}
