package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense


import android.util.Log
import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter

@InjectViewState
class DriverLicensePresenter: BasePresenter<DriverLicenseContract.View>(), DriverLicenseContract.Presenter {

    var CERTIFICATE_CONFRIMED : Boolean = false


    override fun checkData(data: String) {
        Log.d("tag", "flag - $CERTIFICATE_CONFRIMED")
        if (CERTIFICATE_CONFRIMED){
            Log.d("tag", "Отпрвляем данные и переходим на след фрагмент")
            viewState.passData(data)
        }
    }
}

