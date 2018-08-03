package ivanovd422.penaltyapp.data.database.repository.cars

import android.arch.persistence.room.*


@Dao
interface CarsDao{

    @Insert
    fun insertCar(car: Car)

    @Delete
    fun deleteCar(car: Car)

    @Update
    fun updateCar(car: Car)

    @Query("SELECT * FROM cars_table")
    fun getAll(): List<Car>
}