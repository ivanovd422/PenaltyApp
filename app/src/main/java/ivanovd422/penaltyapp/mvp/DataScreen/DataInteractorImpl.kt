package ivanovd422.penaltyapp.mvp.DataScreen

import io.reactivex.Single
import ivanovd422.penaltyapp.data.database.repository.cars.Car
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicense

interface DataInteractorImpl{

    fun getCars(): Single<List<Car>>

    fun getDriverLicenses() : Single<List<DriverLicense>>
}