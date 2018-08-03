package ivanovd422.penaltyapp.mvp.MainScreen

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {


    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MVPInteractor = mainInteractor
}