package ivanovd422.penaltyapp.mvp.OnBoardingScreen

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import com.arellomobile.mvp.MvpAppCompatActivity
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.mvp.OnBoardingScreen.Adapter.BoardingAdapter
import kotlinx.android.synthetic.main.activity_pager.*
import java.text.FieldPosition


class OnBoardingActivity : MvpAppCompatActivity(){

    private var page : Int = 0
    private lateinit var indicators: Array<ImageView>
    private lateinit var pagerAdapter : BoardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)


        indicators = arrayOf(intro_indicator_0, intro_indicator_1, intro_indicator_2,
                intro_indicator_3, intro_indicator_4, intro_indicator_5)



        pagerAdapter = BoardingAdapter(supportFragmentManager)
        container.adapter = pagerAdapter
        container.currentItem = page
        updateIndicators(page)
        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                page = position
                updateIndicators(page)
                when (position) {
                    5 -> finish_container.visibility = View.VISIBLE
                    else -> finish_container.visibility = View.GONE
                }
            }
        })

        next_btn.setOnClickListener { container.currentItem = container.currentItem + 1 }


    }

    private fun updateIndicators(position: Int){
        for (i in 0 until indicators.size){
            indicators[i].setBackgroundResource(
                    when (i) {
                        position -> R.drawable.indicator_selected
                        else -> R.drawable.indicator_unselected
                    }
            )
        }
    }

}

