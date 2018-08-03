package ivanovd422.penaltyapp.di.Modules

import android.content.Context
import android.content.SharedPreferences
import android.support.annotation.Nullable
import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.App
import ivanovd422.penaltyapp.Utils.Constants.SHARED_PREFERENCES_SETTINGS
import javax.inject.Singleton


@Module
class SharedPrefModule{

    @Provides
    @Singleton
     fun providePreferences (context : App): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_SETTINGS, Context.MODE_PRIVATE)
    }
}
