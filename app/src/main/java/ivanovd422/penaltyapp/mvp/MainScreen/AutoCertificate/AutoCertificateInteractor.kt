package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.Utils.Constants.chars
import ivanovd422.penaltyapp.Utils.Constants.fullChars
import ivanovd422.penaltyapp.Utils.Constants.numbers
import ivanovd422.penaltyapp.mvp.Base.InteractorImpl
import javax.inject.Inject


class AutoCertificateInteractor @Inject constructor() : InteractorImpl{

    override fun checkData(data: String): Boolean {

        if (data.length > 9){
            return false
        } else if (data.length < 7){
            return false
        } else{

            if (data.length == 8){
                //проверяем валидность данных, если кол-во символов 8
                return fullChars.contains(data[0].toString()) and numbers.contains(data[1].toString()) and
                        numbers.contains(data[2].toString()) and numbers.contains(data[3].toString()) and
                        fullChars.contains(data[4].toString()) and fullChars.contains(data[5].toString()) and
                        numbers.contains(data[6].toString()) and numbers.contains(data[7].toString())

            } else if (data.length == 9){
                //проверяем валидность данных, если кол-во символов 9
                return (fullChars.contains(data[0].toString()) and numbers.contains(data[1].toString()) and
                        numbers.contains(data[2].toString()) and numbers.contains(data[3].toString()) and
                        chars.contains(data[4].toString()) and chars.contains(data[5].toString()) and
                        numbers.contains(data[6].toString()) and numbers.contains(data[7].toString())
                        and numbers.contains(data[8].toString()))
            } else{
                //проверяем валидность данных, если кол-во символов 7
                return chars.contains(data[0].toString()) and chars.contains(data[1].toString()) and
                        numbers.contains(data[2].toString()) and numbers.contains(data[3].toString()) and
                        numbers.contains(data[4].toString()) and numbers.contains(data[5].toString()) and
                        numbers.contains(data[6].toString())
            }
        }

    }
}
