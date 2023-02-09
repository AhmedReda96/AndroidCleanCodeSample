package com.example.domain.model.baseResponse

import com.google.gson.annotations.SerializedName

open class ApiResponse<T> constructor() {
    @SerializedName("message")
    var message: String = ""

    @SerializedName("status")
    var status: Boolean = false

    @SerializedName("data")
    var data: T? = null

    @Transient
    var request: Any? = null

    @SerializedName("statusCode")
    var statusCode: String = ""

    constructor(message: String, status: Boolean, data: T?) : this() {
        this.message = message
        this.status = status
        this.data = data
    }
}
