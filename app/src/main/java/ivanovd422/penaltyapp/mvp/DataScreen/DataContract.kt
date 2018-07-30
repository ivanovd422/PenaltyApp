package ivanovd422.penaltyapp.mvp.DataScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface DataContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

        fun showAutoCertificate(data: String)
        fun showRegistrationCertificate(data: String)
        fun showDriverLicense(data: String)
    }

    interface Presenter{
    }
}
