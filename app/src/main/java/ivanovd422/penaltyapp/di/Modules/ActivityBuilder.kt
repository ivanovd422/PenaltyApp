package ivanovd422.penaltyapp.di.Modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ivanovd422.penaltyapp.mvp.StartScreen.StartActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindStartActivity (): StartActivity
}
