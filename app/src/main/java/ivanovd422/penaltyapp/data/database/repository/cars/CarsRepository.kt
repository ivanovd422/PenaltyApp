package ivanovd422.penaltyapp.data.database.repository.cars

import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CarsRepository @Inject constructor(private val carsDao: CarsDao) : CarsRepo{


    override fun isCarsRepoEmpty(): Observable<Boolean> {
        return Observable.just(carsDao.getAll().isEmpty())
    }

    override fun insertCar(car: Car): Boolean {

        var flag = false

0

        Single.fromCallable{carsDao.insertCar(car)}
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe({  flag = true },
                        { error ->  flag =  false })

        return flag
    }

    override fun getAllCars(): Single<List<Car>> {


    return Single
            .fromCallable { carsDao.getAll()}
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())

    }
}