package com.example.domain.model.baseViewState

sealed class NetworkingViewState {
    var loader: Loading? = null
    var request: Any? = null

    open class Loading : NetworkingViewState()
    class Success<T>(val item: T) : NetworkingViewState() where T : Any {

        constructor(item: T, loader: Loading) : this(item) {
            this.loader = loader
        }

        constructor(request: T?, response: T, loader: Loading) : this(response, loader) {
            this.request = request
        }
    }

    class Error(val error: Throwable) : NetworkingViewState() {
        constructor(error: Throwable, loader: Loading) : this(error) {
            this.loader = loader
        }

        constructor(request: Any?, error: Throwable, loader: Loading) : this(error, loader) {
            this.request = request
        }
    }

}