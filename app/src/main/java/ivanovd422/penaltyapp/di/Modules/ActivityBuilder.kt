package ivanovd422.penaltyapp.di.Modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ivanovd422.penaltyapp.mvp.DataScreen.DataActivity
import ivanovd422.penaltyapp.mvp.DataScreen.DataActivityModule
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateModule
import ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense.DriverLicenseFragment
import ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense.DriverLicenseModule
import ivanovd422.penaltyapp.mvp.MainScreen.MainActivity
import ivanovd422.penaltyapp.mvp.MainScreen.MainActivityModule
import ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate.RegistratioModule
import ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate.RegistrationFragment
import ivanovd422.penaltyapp.mvp.StartScreen.StartActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindStartActivity (): StartActivity

    @ContributesAndroidInjector(modules = [(DataActivityModule::class)])
    abstract fun bindDataActivity (): DataActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity (): MainActivity

    @ContributesAndroidInjector(modules = [(AutoCertificateModule::class)])
    abstract fun bindAutoCertificateFragment (): AutoCertificateFragment

    @ContributesAndroidInjector(modules = [(DriverLicenseModule::class)])
    abstract fun bindDriverLicenseFragment (): DriverLicenseFragment

    @ContributesAndroidInjector(modules = [(RegistratioModule::class)])
    abstract fun bindRegistrationFragment (): RegistrationFragment

}
