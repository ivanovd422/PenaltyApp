package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter

@InjectViewState
class RegistrationPresenter: BasePresenter<RegistrationContract.View>(), RegistrationContract.Presenter {

    var CERTIFICATE_CONFRIMED : Boolean = false


    override fun checkData(data: String) {
        Log.d("tag", "flag - $CERTIFICATE_CONFRIMED")
        if (CERTIFICATE_CONFRIMED){
            Log.d("tag", "Отпрвляем данные и переходим на след фрагмент")
            viewState.passData(data)
        }
    }


}

