package com.example.domain.model.baseViewState

sealed class NetworkingViewState {
    var request: Any? = null

    open class Loading : NetworkingViewState()
    class Success<T>(val item: T) : NetworkingViewState() where T : Any {
        constructor(request: T?, response: T) : this(response) {
            this.request = request
        }
    }

    class Error(val error: Throwable) : NetworkingViewState() {
        constructor(request: Any?, error: Throwable) : this(error) {
            this.request = request
        }
    }

}