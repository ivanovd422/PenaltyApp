package ivanovd422.penaltyapp.mvp.DataScreen

import dagger.Module
import dagger.Provides

@Module
class DataActivityModule {


    @Provides
    internal fun provideDataInteractor(dataInteractor: DataInteractor): DataInteractorImpl = dataInteractor
}
