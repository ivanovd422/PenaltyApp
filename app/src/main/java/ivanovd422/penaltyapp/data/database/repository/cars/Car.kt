package ivanovd422.penaltyapp.data.database.repository.cars

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cars_table")
data class Car(

        @PrimaryKey(autoGenerate = true)
        var id: Int?,
        var govNumb: String,
        var stsNumb: String,
        var title: String?
)



