package ivanovd422.penaltyapp.mvp.DataScreen

import com.arellomobile.mvp.InjectViewState
import ivanovd422.penaltyapp.mvp.Base.BasePresenter
import javax.inject.Inject


@InjectViewState
class DataPresenter @Inject constructor(val dataInteractor: DataInteractor):
        BasePresenter<DataContract.View>(), DataContract.Presenter{

     var autoCertificateData : String = ""
     var autoRegistrationCertificate : String = ""
     var autoDriverLicense : String = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (dataInteractor.getCars().blockingGet().isNotEmpty()){
            autoCertificateData = dataInteractor.getCars().blockingGet()[0].govNumb
            autoRegistrationCertificate = dataInteractor.getCars().blockingGet()[0].stsNumb
        }


        if (dataInteractor.getDriverLicenses().blockingGet().isNotEmpty()){
            autoDriverLicense = dataInteractor.getDriverLicenses().blockingGet()[0].numb
        }




    }

    override fun attachView(view: DataContract.View?) {
        super.attachView(view)

        viewState.showAutoCertificate(autoCertificateData)
        viewState.showRegistrationCertificate(autoRegistrationCertificate)
        viewState.showDriverLicense(autoDriverLicense)

    }
}
