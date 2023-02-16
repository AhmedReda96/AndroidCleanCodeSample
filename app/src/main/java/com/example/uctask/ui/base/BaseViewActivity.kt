package com.example.uctask.ui.base

import android.util.Log
import androidx.activity.ComponentActivity
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.baseViewState.NetworkingViewState
import com.example.uctask.R
import com.example.uctask.utils.showLog

open class BaseViewActivity : ComponentActivity() {
    protected open fun handleUI(viewState: NetworkingViewState?) {

        when (viewState) {

            is NetworkingViewState.Loading -> {
                showLoader()
            }

            is NetworkingViewState.Error -> {
                try {
                    Log.d("TAG", "handleResponse: ${viewState.error.printStackTrace()}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            is NetworkingViewState.Success<*> -> {
                when (viewState.item) {
                    is ApiResponse<*> -> {
                        (viewState.item as ApiResponse<*>).request = viewState.request
                        handleResponse(viewState)
                    }
                    else -> showFailureMessage(getString(R.string.message_server_error))

                }
            }
            else -> throw IllegalArgumentException("Unknown view state ${viewState?.javaClass?.simpleName}")

        }


    }

    private fun showLoader() {
        //show loader here
    }

    private fun showFailureMessage(message: String) = showLog(message)


    private fun handleResponse(viewState: NetworkingViewState.Success<*>) {
        handleResponse(viewState.item as ApiResponse<*>)
    }

    @Suppress("UNCHECKED_CAST")
    protected open fun handleResponse(response: ApiResponse<*>) {
    }


}
