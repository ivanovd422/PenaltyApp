package ivanovd422.penaltyapp.di.Modules

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import ivanovd422.penaltyapp.Utils.Constants
import ivanovd422.penaltyapp.data.database.AppDatabase
import ivanovd422.penaltyapp.data.database.repository.cars.CarsRepo
import ivanovd422.penaltyapp.data.database.repository.cars.CarsRepository
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicenseRepo
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicenseRepository
import javax.inject.Singleton

@Module
class DataBaseModule{

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, Constants.APP_DB_NAME).build()


    @Provides
    @Singleton
    internal fun provideCarsRepoHelper(appDatabase: AppDatabase): CarsRepo =
            CarsRepository(appDatabase.carsDao())

    @Provides
    @Singleton
    internal fun provideDriverLicenseRepoHelper(appDatabase: AppDatabase): DriverLicenseRepo =
            DriverLicenseRepository(appDatabase.driverLicenseDao())
}
