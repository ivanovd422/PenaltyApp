package ivanovd422.penaltyapp.mvp.MainScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


interface MainScreenContract {

    @StateStrategyType(value = SkipStrategy::class)
    interface View : MvpView{

        fun clearBackStack()

        fun changeFragment(f: Fragment, cleanStack: Boolean = false)

        fun addNextFragment()

    }

    interface Presenter{

        fun saveData()

        fun fragmentSkipped()
    }
}