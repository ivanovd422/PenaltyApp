package ivanovd422.penaltyapp.di.Modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.App
import javax.inject.Singleton


@Module
class AppModule() {
    @Provides
    @Singleton
    fun provideApplication(app : App): Context = app
}
