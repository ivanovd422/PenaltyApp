package ivanovd422.penaltyapp.di.Modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ivanovd422.penaltyapp.mvp.DataScreen.DataActivity
import ivanovd422.penaltyapp.mvp.MainScreen.MainActivity
import ivanovd422.penaltyapp.mvp.StartScreen.StartActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindStartActivity (): StartActivity

    @ContributesAndroidInjector
    abstract fun bindDataActivity (): DataActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): MainActivity
}
