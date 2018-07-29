package ivanovd422.penaltyapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import ivanovd422.penaltyapp.App
import ivanovd422.penaltyapp.di.Modules.ActivityBuilder
import ivanovd422.penaltyapp.di.Modules.AppModule
import ivanovd422.penaltyapp.di.Modules.SharedPrefModule
import javax.inject.Singleton


@Singleton
@Component(modules=arrayOf(AppModule::class, AndroidSupportInjectionModule::class,
        SharedPrefModule::class, ActivityBuilder::class))
interface AppComponent {

    fun inject (app:App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Application): Builder

        fun build(): AppComponent
    }


}