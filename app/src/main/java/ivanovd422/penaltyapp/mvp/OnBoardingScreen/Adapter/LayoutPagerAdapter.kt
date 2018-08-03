package ivanovd422.penaltyapp.mvp.OnBoardingScreen.Adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import ivanovd422.penaltyapp.Extensions.inflate
import ivanovd422.penaltyapp.R


class LayoutPagerAdapter(val layoutInflater: LayoutInflater): PagerAdapter(){

    val layouts: Array<Int> = arrayOf(R.layout.walk_layout_frag1, R.layout.walk_layout_frag2,
            R.layout.walk_layout_frag3, R.layout.walk_layout_frag4,
            R.layout.walk_layout_frag5, R.layout.walk_layout_frag6)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        parent.removeView(`object` as View)
    }

    override fun instantiateItem(viewGroup: ViewGroup, position: Int): Any {
        var view = layoutInflater.inflate(layouts[position], null)
        viewGroup.addView(view)

        return view
    }

}