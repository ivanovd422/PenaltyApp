package ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ivanovd422.penaltyapp.Extensions.inflate
import ivanovd422.penaltyapp.R
import kotlinx.android.synthetic.main.auto_certificate_layout.*

class AutoCertificateFragment : MvpAppCompatFragment(), AutoCertificateContract.View{


    @InjectPresenter
    lateinit var presenter: AutoCertificatePresenter
    private var dialog: AlertDialog? = null
     lateinit var skipFragment : SkipFragment
     lateinit var  certificateData : AutoCertificateData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.auto_certificate_layout)


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        skipFragment = context as SkipFragment
        certificateData = context as AutoCertificateData
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        skip_btn.setOnClickListener{presenter.viewState.showDialog()}
        continue_btn.setOnClickListener{presenter.checkData(auto_et.text.toString())}

        //x буквы, d цифры
        //x ddd xx dd     x ddd xx ddd - легковые
        //xx ddd dd    xx ddd ddd - такси
        //dddd xx dd    dddd xx ddd  - мото

        val numbers: Array<String> = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val chars: Array<String> = arrayOf("А", "В", "Е", "К", "М", "Н", "О", "Р", "K", "К",
                "С", "Т", "У", "Х", "A", "B", "E", "M", "H", "O", "P", "C", "T", "Y", "X")
        val fullChars: Array<String> = arrayOf("А", "В", "Е", "К", "М", "Н", "О", "Р", "K", "К",
                "С", "Т", "У", "Х", "A", "B", "E", "M", "H", "O", "P", "C", "T", "Y", "X", "0",
                "1", "2", "3", "4", "5", "6", "7", "8", "9")

        auto_et.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(p0: Editable) {

                if (!p0.toString().equals(p0.toString().toUpperCase())){
                    var text = p0.toString().toUpperCase()
                    auto_et.setText(text)
                    auto_et.setSelection(text.length)
                }

                var numb = p0.toString().replace(" ", "")

                if (numb.length > 9){
                    auto_et.error = resources.getString(R.string.incorrect_numb)
                    presenter.CERTIFICATE_CONFRIMED = false
                } else if (numb.length < 7){
                    presenter.CERTIFICATE_CONFRIMED = false
                } else{

                    if (numb.length == 8){
                        if (fullChars.contains(numb[0].toString()) and numbers.contains(numb[1].toString()) and
                                numbers.contains(numb[2].toString()) and numbers.contains(numb[3].toString()) and
                                fullChars.contains(numb[4].toString()) and fullChars.contains(numb[5].toString()) and
                                numbers.contains(numb[6].toString()) and numbers.contains(numb[7].toString())){
                            presenter.CERTIFICATE_CONFRIMED = true
                        } else{
                            auto_et.error = resources.getString(R.string.incorrect_numb)
                            presenter.CERTIFICATE_CONFRIMED = false
                        }

                    } else if (numb.length == 9){
                        if (fullChars.contains(numb[0].toString()) and numbers.contains(numb[1].toString()) and
                                numbers.contains(numb[2].toString()) and numbers.contains(numb[3].toString()) and
                                chars.contains(numb[4].toString()) and chars.contains(numb[5].toString()) and
                                numbers.contains(numb[6].toString()) and numbers.contains(numb[7].toString())
                                and numbers.contains(numb[8].toString())){
                            presenter.CERTIFICATE_CONFRIMED = true
                        } else{
                            auto_et.error = resources.getString(R.string.incorrect_numb)
                            presenter.CERTIFICATE_CONFRIMED = false
                        }
                    } else{

                        if (chars.contains(numb[0].toString()) and chars.contains(numb[1].toString()) and
                                numbers.contains(numb[2].toString()) and numbers.contains(numb[3].toString()) and
                                numbers.contains(numb[4].toString()) and numbers.contains(numb[5].toString()) and
                                numbers.contains(numb[6].toString())){
                            presenter.CERTIFICATE_CONFRIMED = true
                        } else{
                            presenter.CERTIFICATE_CONFRIMED = false
                        }

                    }
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
                })
                .setNegativeButton("ВВЕСТИ НОМЕР", {dialog, i ->
                    presenter.viewState.dismissDialog()
                })
                .setOnDismissListener({
                    presenter.viewState.dismissDialog()
                })


        dialog = builder.create()
        dialog?.show()

    }

    override fun dismissDialog() {
        dialog?.dismiss()
    }


    public interface SkipFragment{
        fun onSkipFragment()
    }

    public interface AutoCertificateData{
        fun passCertificateData(data: String)
    }

    override fun onSkipStage() {
        skipFragment.onSkipFragment()

    }

    override fun passData(data: String) {
        certificateData.passCertificateData(data)
    }
}
