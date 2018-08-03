package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import ivanovd422.penaltyapp.Utils.Constants
import ivanovd422.penaltyapp.Utils.Constants.fullChars
import ivanovd422.penaltyapp.Utils.Constants.numbers
import ivanovd422.penaltyapp.mvp.Base.InteractorImpl
import javax.inject.Inject

class RegistrationInteractor  @Inject constructor() : InteractorImpl {

    override fun checkData(data: String): Boolean {

        if (data.length == 10){
            return (numbers.contains(data[0].toString()) and numbers.contains(data[1].toString())
                    and fullChars.contains(data[2].toString()) and fullChars.contains(data[3].toString())
                    and numbers.contains(data[4].toString()) and numbers.contains(data[5].toString())
                    and numbers.contains(data[6].toString()) and numbers.contains(data[7].toString())
                    and numbers.contains(data[8].toString()) and numbers.contains(data[9].toString()))
        } else return false


    }
}
