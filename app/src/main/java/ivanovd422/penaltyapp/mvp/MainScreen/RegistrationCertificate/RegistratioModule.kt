package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.mvp.Base.InteractorImpl

@Module
class RegistratioModule{
    @Provides
    fun provideDriverLicenseModule(registrationInteractor: RegistrationInteractor):
            InteractorImpl = registrationInteractor
}
