package com.cts.demo.webservice.dto.response


open class BaseResponse {
    var errorYN: String? = null
    var status: String? = null
    var message: String? = null
    var description: String? = null
    var pageNo: Int? = null
    var totalPages: Int? = null
    var total: Int? = null
    var totalCount: Int? = null
}