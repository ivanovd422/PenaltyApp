package ivanovd422.penaltyapp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ivanovd422.penaltyapp.data.database.repository.cars.Car
import ivanovd422.penaltyapp.data.database.repository.cars.CarsDao
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicense
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicenseDao


@Database(entities = [(DriverLicense::class), (Car::class)], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun carsDao(): CarsDao

    abstract fun driverLicenseDao(): DriverLicenseDao
}