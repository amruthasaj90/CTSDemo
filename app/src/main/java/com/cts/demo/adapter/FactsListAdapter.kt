package com.cts.demo.adapter

import android.content.Context
import android.view.ViewGroup
import com.cts.demo.R
import com.cts.demo.databinding.InflateFactsListItemBinding
import com.cts.demo.listener.BaseRecyclerAdapterListener
import com.cts.demo.model.response.Facts
import com.cts.demo.viewholder.FactsListViewHolder

class FactsListAdapter(
    val mContext: Context,
    data: MutableList<Facts>?,
    var listener: BaseRecyclerAdapterListener<Facts>
) :

    BaseRecyclerAdapter<Facts, FactsListViewHolder>(data) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsListViewHolder {
        return FactsListViewHolder(
            mContext,
            inflateDataBinding(
                R.layout.inflate_facts_list_item,
                parent
            ) as InflateFactsListItemBinding, listener
        )
    }
}

