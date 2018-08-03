package ivanovd422.penaltyapp.mvp.DataScreen

import io.reactivex.Single
import ivanovd422.penaltyapp.data.database.repository.cars.Car
import ivanovd422.penaltyapp.data.database.repository.cars.CarsRepo
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicense
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicenseRepo
import java.util.concurrent.Callable
import javax.inject.Inject


class DataInteractor @Inject internal constructor(private val carsRepoHelper: CarsRepo,
                                                 private val driverLicenseRepoHelper:
                                                 DriverLicenseRepo): DataInteractorImpl{


    override fun getCars(): Single<List<Car>> {
        return carsRepoHelper.getAllCars()
    }

    override fun getDriverLicenses(): Single<List<DriverLicense>> {
        return driverLicenseRepoHelper.getAllDriverLicense()
    }
}
