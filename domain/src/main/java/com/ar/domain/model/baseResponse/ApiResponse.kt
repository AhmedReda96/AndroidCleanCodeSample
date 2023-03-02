package com.ar.domain.model.baseResponse

import com.google.gson.annotations.SerializedName

open class ApiResponse<T> constructor() {
    @SerializedName("count")
    var count: Int? = null

    @SerializedName("next")
    var next: String? = null

    @SerializedName("previous")
    var previous: String? = null

    @SerializedName("results")
    var data: T? = null

    @Transient
    var request: Any? = null

    @SerializedName("statusCode")
    var statusCode: String = ""

    constructor(count: Int, next: String,previous:String, data: T?) : this() {
        this.count = count
        this.next = next
        this.previous = previous
        this.data = data
    }
}
