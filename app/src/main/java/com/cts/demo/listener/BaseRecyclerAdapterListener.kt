package com.techversant.evara.listener


interface BaseRecyclerAdapterListener<T> {

    fun onClickItem(position: Int, data: T?)

}