package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.mvp.Base.InteractorImpl

@Module
class AutoCertificateModule {


    @Provides
     fun provideAutoCertificateInteractor(autoCertificateInteractor: AutoCertificateInteractor):
            InteractorImpl = autoCertificateInteractor
}
