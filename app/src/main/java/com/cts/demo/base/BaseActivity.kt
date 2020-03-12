package  com.cts.demo.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<VM : BaseViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewBinding: VB

    abstract fun initializeView(): VM

    abstract fun layoutRes(): Int


    abstract fun initializeListener()

    open fun onViewModelCreated() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initContext(applicationContext)


        viewModel.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutRes())
        viewBinding.setLifecycleOwner(this)


        initializeListener()


    }

    fun showFocus(editText: EditText) {
        editText.requestFocus()
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }


    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }


    protected val viewModel: VM by lazy {

        initializeView()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.startActivityForResult(requestCode, resultCode, data)
    }


    fun <navigateTo> navigateTo(
        className: Class<navigateTo>,
        isFinishCurrentActivity: Boolean = false,
        bundle: Bundle? = null,
        needDefaultAnim: Boolean = true
    ) {
        val intent = Intent(this, className)
        if (bundle != null)
            intent.putExtras(bundle)
        startActivity(intent)
        if (needDefaultAnim)
            if (isFinishCurrentActivity)
                finish()
    }

}
