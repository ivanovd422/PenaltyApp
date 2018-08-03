package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense

import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.mvp.Base.InteractorImpl

@Module
class DriverLicenseModule {
    @Provides
    fun provideDriverLicenseModule(driverLicenseModuleInteractor: DriverLicenseInteractor):
            InteractorImpl = driverLicenseModuleInteractor
}
