package ivanovd422.penaltyapp.data.database.repository.driverLicense

import io.reactivex.Observable
import io.reactivex.Single

interface DriverLicenseRepo {

    fun isDriverLicenseRepoEmpty(): Observable<Boolean>

    fun insertDriverLicense(driverLicense: DriverLicense): Boolean

    fun getAllDriverLicense(): Single<List<DriverLicense>>

}
