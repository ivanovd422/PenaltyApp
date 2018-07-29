package ivanovd422.penaltyapp.mvp.Base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<View : MvpView> : MvpPresenter<View>(){

    var mCompositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        mCompositeDisposable.clear()
        super.onDestroy()
    }
}
