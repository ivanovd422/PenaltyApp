package ivanovd422.penaltyapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ivanovd422.penaltyapp.App
import ivanovd422.penaltyapp.di.Modules.ActivityBuilder
import ivanovd422.penaltyapp.di.Modules.AppModule
import ivanovd422.penaltyapp.di.Modules.DataBaseModule
import ivanovd422.penaltyapp.di.Modules.SharedPrefModule
import javax.inject.Singleton


@Singleton
@Component(modules=arrayOf(AppModule::class, AndroidSupportInjectionModule::class,
        SharedPrefModule::class, ActivityBuilder::class, DataBaseModule::class))
interface AppComponent : AndroidInjector<App> {


    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
    }


}