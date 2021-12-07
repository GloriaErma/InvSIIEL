package com.misiontic2022.inventariosiiel.network

import com.misiontic2022.inventariosiiel.model.productd
import com.google.firebase.firestore.FirebaseFirestore
//Se le volvio a dar en cargar dependencias, en caso de que no sirva deben seguir las siguentes instrucciones
//para deshabilitar el trabajo offline https://stackoverflow.com/questions/28712025/how-to-disable-gradle-offline-mode-in-android-studio


const val PRODUCT_COLLECTION_NAME="productd"
class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getProducts(callback: Callback<List<productd>>){
        firebaseFirestore.collection(PRODUCT_COLLECTION_NAME)
            .get()
            //Error estaba en el result --> es con un solo ->
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(productd::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}
