package ivanovd422.penaltyapp.data.database.repository.cars

import io.reactivex.Observable
import io.reactivex.Single

interface CarsRepo {

    fun isCarsRepoEmpty(): Observable<Boolean>

    fun insertCar(car: Car): Boolean

    fun getAllCars(): Single<List<Car>>

}
