package ivanovd422.penaltyapp.mvp.OnBoardingScreen.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ivanovd422.penaltyapp.mvp.OnBoardingScreen.Fragments.*

class BoardingAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            3 -> Fragment4()
            4 -> Fragment5()
            else -> Fragment6()
        }
    }

    override fun getCount(): Int {
        return 6
    }
}
