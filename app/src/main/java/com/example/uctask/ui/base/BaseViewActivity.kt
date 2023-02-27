package com.example.uctask.ui.base

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.baseViewState.NetworkingViewState
import com.example.uctask.utils.ConstantStrings
import com.example.uctask.utils.showLog

open class BaseViewActivity : ComponentActivity() {
    @Composable
    protected open fun HandleUI(viewState: NetworkingViewState?) {
        when (viewState) {
            is NetworkingViewState.Loading -> {
                showLoader()
            }
            is NetworkingViewState.Error -> with(viewState) {
                try {
                    showLog(true, error.message.toString())
                } catch (e: Exception) {
                    showLog(true, e.message.toString())
                }
                dismissLoader()
            }

            is NetworkingViewState.Success<*> -> with(viewState) {
                (item as ApiResponse<*>).request = request
                HandleResponse(item as ApiResponse<*>)
                dismissLoader()
            }
            else -> with(ConstantStrings.UNKNOWN_VIEW_STATE + this.javaClass.simpleName) {
                showLog(true, this)
            }
        }


    }

    private fun showLoader() {
        //show loader here
    }

    private fun dismissLoader() {
        //dismiss loader here
    }


    @Composable
    @Suppress("UNCHECKED_CAST")
    protected open fun HandleResponse(response: ApiResponse<*>) {
    }


}
