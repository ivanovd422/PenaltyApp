package ivanovd422.penaltyapp.data.database.repository.driverLicense

import android.arch.persistence.room.*

@Dao
interface DriverLicenseDao{

    @Insert
    fun insertCar(driverLicense: DriverLicense)

    @Delete
    fun deleteCar(driverLicense: DriverLicense)

    @Update
    fun updateCar(driverLicense: DriverLicense)

    @Query("SELECT * FROM driver_license_table")
    fun getAll(): List<DriverLicense>
}
