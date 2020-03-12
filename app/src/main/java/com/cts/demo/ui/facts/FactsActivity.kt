package com.cts.demo.ui.facts

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.isEmpty
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cts.demo.R
import com.cts.demo.adapter.FactsListAdapter
import com.cts.demo.base.BaseActivity
import com.cts.demo.databinding.ActivityFactsBinding
import com.cts.demo.listener.BaseRecyclerAdapterListener
import com.cts.demo.model.response.Facts
import com.cts.demo.model.response.FactsResponse
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_facts.*

class FactsActivity : BaseActivity<FactsViewModel, ActivityFactsBinding>() {
    var factsList: ArrayList<Facts> = ArrayList()

    override fun initializeView(): FactsViewModel {
        val viewModel: FactsViewModel by viewModels()
        return viewModel
    }

    override fun layoutRes(): Int {
        return R.layout.activity_facts
    }

    override fun initializeListener() {

        viewBinding.viewModel = viewModel
        val layoutManager = LinearLayoutManager(applicationContext)
        viewBinding.rvFactsList.layoutManager = layoutManager
        viewBinding.factsAdapter = adapter

        viewModel.factsList.observe(this, Observer { result ->
            if (result != null) {
                val factsListResponse =
                    viewModel.handleReponse(this, result) as FactsResponse?
                Log.e("factsListResponse",Gson().toJson(factsListResponse))
                if (factsListResponse != null && !factsListResponse.rows.isNullOrEmpty()) {
                    factsList.clear()
                    factsList.addAll(factsListResponse.rows!!)
                    adapter.notifyDataSetChanged()

                } else {

                }
            }
        })
    }

    private val adapter by lazy {
        FactsListAdapter(applicationContext, factsList, listener)
    }


    private val listener = object :
        BaseRecyclerAdapterListener<Facts> {
        override fun onClickItem(position: Int, data: Facts?) {

        }
    }
}
