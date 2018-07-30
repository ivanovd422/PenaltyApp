package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter

@InjectViewState
class RegistrationPresenter: BasePresenter<RegistrationContract.View>(), RegistrationContract.Presenter {

    var CERTIFICATE_CONFRIMED : Boolean = false

    override fun checkData(data: String) {
        if (CERTIFICATE_CONFRIMED){
            viewState.passData(data)
        }
    }


}

