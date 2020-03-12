package com.cts.demo.viewholder

import android.content.Context
import com.cts.demo.databinding.InflateFactsListItemBinding
import com.cts.demo.listener.BaseRecyclerAdapterListener
import com.cts.demo.model.response.Facts

class FactsListViewHolder(
    val mContext: Context,
    view: InflateFactsListItemBinding,
    var listener: BaseRecyclerAdapterListener<Facts>
) : BaseViewHolder<Facts, InflateFactsListItemBinding>(view) {


    override fun populateData(data: Facts) {

    }

}