package com.misiontic2022.inventariosiiel.network

interface Callback <T>{
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}