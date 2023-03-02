package com.ar.sample.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.IdRes
import androidx.compose.runtime.Composable
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.ar.domain.model.baseResponse.ApiResponse
import com.ar.domain.model.baseViewState.NetworkingViewState
import com.ar.sample.utils.ConstantStrings
import com.ar.sample.utils.showLog
import com.example.sample.R

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
