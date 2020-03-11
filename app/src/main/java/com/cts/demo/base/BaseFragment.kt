package com.digicom.onesqft.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding> : Fragment() {
    protected lateinit var viewBinding: VB

    abstract fun initializeViewModel(): VM

    abstract fun layoutRes(): Int

    abstract fun initializeListener()


    open fun onViewModelCreated() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        viewBinding.lifecycleOwner = this
        initializeListener()
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initContext(activity?.applicationContext)
        viewModel.onCreate(arguments)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.startActivityForResult(requestCode, resultCode, data)
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
        initializeViewModel()
    }

}