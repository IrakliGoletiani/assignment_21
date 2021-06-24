package com.example.navigationdrawer

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

object ApiCall {
    suspend fun getData() {
        withContext(Dispatchers.IO){
            while (isActive){
                d("myLog", "get api response")

                delay(5000)
            }
        }
    }
}

