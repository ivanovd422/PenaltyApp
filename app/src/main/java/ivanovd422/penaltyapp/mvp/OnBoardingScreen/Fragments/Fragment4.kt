package ivanovd422.penaltyapp.mvp.OnBoardingScreen.Fragments



import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import ivanovd422.penaltyapp.Extensions.inflate
import ivanovd422.penaltyapp.R


class Fragment4: MvpAppCompatFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "onCreate fragment")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.walk_layout_frag4)


    }
}
