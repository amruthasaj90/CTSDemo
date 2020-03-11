package com.cts.demo.model

data class ErrorResponse(val Error: ErrorData?)

data class ErrorData(val ErrorCode: String?,
                         val ErrorMessage: String?)