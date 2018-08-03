package ivanovd422.penaltyapp.mvp.MainScreen.DriverLicense


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import ivanovd422.penaltyapp.Extensions.inflate
import ivanovd422.penaltyapp.R
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificateFragment
import ivanovd422.penaltyapp.mvp.MainScreen.AutoCertificate.AutoCertificatePresenter
import kotlinx.android.synthetic.main.registration_layout.*
import javax.inject.Inject

class DriverLicenseFragment: MvpAppCompatFragment(), DriverLicenseContract.View,
        HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector : DispatchingAndroidInjector<Fragment>


    @Inject
    @InjectPresenter
    lateinit var presenter:DriverLicensePresenter


    @ProvidePresenter
    fun providePresenter(): DriverLicensePresenter  {
        return presenter
    }


    private var dialog: AlertDialog? = null
    lateinit var driverLicenseData : DriverLicenseData
    lateinit var skipFragment : SkipFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.driver_license_layout)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        driverLicenseData = context as DriverLicenseData
        skipFragment = context as SkipFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        skip_btn.setOnClickListener{presenter.viewState.showDialog()}
        continue_btn.setOnClickListener{presenter.isDataValid()}

        auto_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {

                if (!p0.toString().equals(p0.toString().toUpperCase())){
                    val text = p0.toString().toUpperCase()
                    auto_et.setText(text)
                    auto_et.setSelection(text.length)
                }
                val numb = p0.toString().replace(" ", "")

                presenter.enteredText(numb)
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
                    presenter.onDialogPositiveButton()

                })
                .setNegativeButton("ВВЕСТИ НОМЕР", {dialog, i ->
                    presenter.onDialogNegativeButton()
                })
                .setOnDismissListener({
                    presenter.onDialogDismiss()
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

    override fun onSkipStage() {
        skipFragment.onSkipFragment()
    }

    public interface DriverLicenseData{
        fun passDriverLicenseData(data: String)
    }

    override fun passData(data: String) {
        driverLicenseData.passDriverLicenseData(data)
    }


    override fun showTextError() {
        auto_et.error = resources.getString(R.string.incorrect_doc_numb)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}
