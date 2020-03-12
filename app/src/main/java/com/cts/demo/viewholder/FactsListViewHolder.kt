package com.cts.demo.viewholder

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.cts.demo.R
import com.cts.demo.databinding.InflateFactsListItemBinding
import com.cts.demo.listener.BaseRecyclerAdapterListener
import com.cts.demo.model.response.Facts

class FactsListViewHolder(
    val mContext: Context,
    view: InflateFactsListItemBinding,
    var listener: BaseRecyclerAdapterListener<Facts>
) : BaseViewHolder<Facts, InflateFactsListItemBinding>(view) {


    override fun populateData(data: Facts) {
        viewDataBinding.factsData = data
        viewDataBinding.listener = listener

        if(!data.imageHref.isNullOrEmpty()) {
            val requestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(300, 300)
            Glide.with(mContext)
                .load(data.imageHref)
                .thumbnail(0.5f).apply(requestOptions)
                .into(viewDataBinding.ivFacts)
        }
    }

}