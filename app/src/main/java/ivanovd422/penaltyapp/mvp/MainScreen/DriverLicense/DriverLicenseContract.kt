package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface DriverLicenseContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

        fun showDialog()

        fun dismissDialog()


        @StateStrategyType(value = SkipStrategy::class)
        fun onSkipStage()

        @StateStrategyType(value = SkipStrategy::class)
        fun passData(data: String)

    }

    interface Presenter{

        fun checkData(data : String)
    }
}
