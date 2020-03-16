package com.cts.demo.listener


interface BaseRecyclerAdapterListener<T> {

    fun onClickItem(position: Int, data: T?)

}