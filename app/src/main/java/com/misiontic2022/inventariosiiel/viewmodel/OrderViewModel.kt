package com.misiontic2022.inventariosiiel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misiontic2022.inventariosiiel.model.productd
import com.misiontic2022.inventariosiiel.network.Callback
import com.misiontic2022.inventariosiiel.network.FirestoreService

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listProducts: MutableLiveData<List<productd>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getProductsFromFirebase()
    }

    private fun getProductsFromFirebase() {
        firestoreService.getProducts(object : Callback<List<productd>> {

            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<productd>?) {
                listProducts.postValue(result)
                processFinished()
            }

        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}