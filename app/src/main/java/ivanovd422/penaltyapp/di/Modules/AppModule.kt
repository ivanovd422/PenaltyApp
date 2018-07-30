package ivanovd422.penaltyapp.di.Modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import ivanovd422.penaltyapp.App
import javax.inject.Singleton


@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideContext(app: App): Context
}