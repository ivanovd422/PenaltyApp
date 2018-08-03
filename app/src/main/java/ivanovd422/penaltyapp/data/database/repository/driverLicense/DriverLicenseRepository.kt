package ivanovd422.penaltyapp.data.database.repository.driverLicense

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import javax.inject.Inject


class DriverLicenseRepository@Inject constructor(private val dao: DriverLicenseDao) : DriverLicenseRepo{


    override fun isDriverLicenseRepoEmpty(): Observable<Boolean> {
        return Observable.just(dao.getAll().isEmpty())
    }

    override fun insertDriverLicense(driverLicense: DriverLicense): Boolean {

        var  flag: Boolean = false
        Single.fromCallable({dao.insertCar(driverLicense)})
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ flag = true }, { flag = false })

        return flag
    }

    override fun getAllDriverLicense(): Single<List<DriverLicense>> {
        return Single
                .fromCallable { dao.getAll()}
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
    }
}
