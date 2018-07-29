package ivanovd422.penaltyapp.mvp.MainScreen.RegistrationCertificate

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ivanovd422.penaltyapp.Extensions.inflate
import ivanovd422.penaltyapp.R
import kotlinx.android.synthetic.main.registration_layout.*

class RegistrationFragment: MvpAppCompatFragment(), RegistrationContract.View{


    @InjectPresenter
    lateinit var presenter:RegistrationPresenter
    private var dialog: AlertDialog? = null
    lateinit var skipFragment : SkipFragment
    lateinit var registrationData : RegistrationData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "onCreate fragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.registration_layout)


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        skipFragment = context as SkipFragment
        registrationData = context as RegistrationData
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("tag", "onActivityCreated fragment")

        skip_btn.setOnClickListener{presenter.viewState.showDialog()}
        continue_btn.setOnClickListener{presenter.checkData(auto_et.text.toString())}

        val numbers: Array<String> = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val chars: Array<String> = arrayOf("А", "В", "Е", "К", "М", "Н", "О", "Р",
                "С", "Т", "У", "Х", "A", "B", "E", "M", "H", "O", "P", "C", "T", "Y", "X")

        auto_et.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(p0: Editable) {

                //ПЕРЕВОДИМ СИМВОЛЫ В ВЕРХНИЙ РЕГИСТР
                if (!p0.toString().equals(p0.toString().toUpperCase())){
                    var text = p0.toString().toUpperCase()
                    auto_et.setText(text)
                    auto_et.setSelection(text.length)
                }

                //УБИРАЕМ ПРОБЕЛЫ
                var numb = p0.toString().replace(" ", "")
                Log.d("tag", "стринг без пробелов - " + numb)

                //TODO изменить
                if (numb.length > 10){
                    auto_et.error = resources.getString(R.string.incorrect_numb)
                    //todo говорим презентеру что всё плохо
                    presenter.CERTIFICATE_CONFRIMED = false
                    Log.d("tag", "Всё плохо")

                }  else  if (numb.length < 10){
                    presenter.CERTIFICATE_CONFRIMED = false
                    Log.d("tag", "Всё плохо")
                } else{

                  var newNumber = numb.substring(0,2) + " " + numb.substring(2, 4) + " " + numb.substring(4, numb.length)
                    Log.d("tag", "newNumber - " + newNumber)
                    presenter.CERTIFICATE_CONFRIMED = true
                }


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    override fun showDialog() {
        val builder = AlertDialog.Builder(this.requireContext())

                .setMessage(getString(R.string.auto_dialog_msg))
                .setPositiveButton("Пропустить", { dialog, i ->
                    presenter.viewState.dismissDialog()
                    presenter.viewState.onSkipStage()
                    //todo закрыть в презентере
                })
                .setNegativeButton("ВВЕСТИ НОМЕР", {dialog, i ->
                    presenter.viewState.dismissDialog()
                    //todo закрыть в презентере
                })
                .setOnDismissListener({
                    //todo закрыть в презентере
                    presenter.viewState.dismissDialog()
                })


        dialog = builder.create()
        dialog?.show()

    }

    override fun dismissDialog() {
        Log.d("tag", "dismissDialog")
        dialog?.dismiss()
    }



    public interface SkipFragment{
        fun onSkipFragment()
    }

    public interface RegistrationData{
        fun passRegistrationData(data: String)
    }

    override fun passData(data: String) {
        registrationData.passRegistrationData(data)

    }

    override fun onSkipStage() {
        Log.d("tag", "onSkipStage")
        skipFragment.onSkipFragment()

    }


}
