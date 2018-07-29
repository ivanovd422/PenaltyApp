package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


interface AutoCertificateContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

    fun showDialog()

    fun dismissDialog()


        @StateStrategyType(value = SkipStrategy::class)
    fun passData(data: String)

        @StateStrategyType(value = SkipStrategy::class)
        fun onSkipStage()

    }

    interface Presenter{

        fun checkData(data : String)
    }
}
