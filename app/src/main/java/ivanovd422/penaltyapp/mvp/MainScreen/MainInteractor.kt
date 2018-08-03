package ivanovd422.penaltyapp.mvp.MainScreen

import android.content.SharedPreferences
import ivanovd422.penaltyapp.Utils.Constants.WIZARD
import ivanovd422.penaltyapp.data.database.repository.cars.Car
import ivanovd422.penaltyapp.data.database.repository.cars.CarsRepo
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicense
import ivanovd422.penaltyapp.data.database.repository.driverLicense.DriverLicenseRepo
import javax.inject.Inject


class MainInteractor @Inject internal constructor(private val carsRepoHelper: CarsRepo,
                                                  private val driverLicenseRepoHelper:
                                                  DriverLicenseRepo, private val
                                                  sharedPreferences: SharedPreferences): MVPInteractor {

    override fun insertData(govNumber: String, stsNumber: String, driverLicense: String) {

        if (!govNumber.equals("") and !stsNumber.equals("")){
            carsRepoHelper.insertCar(Car(null, govNumber, stsNumber, null))
        }

        if (!driverLicense.equals("")){
            driverLicenseRepoHelper.insertDriverLicense(DriverLicense(null, driverLicense, null))
        }

        if (!govNumber.equals("") and !stsNumber.equals("") and !driverLicense.equals("")){
            sharedPreferences.edit().putBoolean(WIZARD, true).apply()
        }
    }


}
