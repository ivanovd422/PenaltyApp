package ivanovd422.penaltyapp.data.database.repository.driverLicense

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "driver_license_table")
data class DriverLicense(

        @PrimaryKey(autoGenerate = true)
        var id: Int?,
        var numb: String,
        var title: String?
)