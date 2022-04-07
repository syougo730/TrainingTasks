package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * チェック状態を管理するVM
 */
class CheckedViewModel: ViewModel() {
    var tag = "checkedViewModel"
    private val _check = MutableLiveData<Boolean>()
    var checkbox2 : Boolean = false

    // viewmodel
    val check_status: LiveData<Boolean>
        get() = _check
    fun checkLog() {
        Log.d(tag , check_status.toString())
    }


    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }



}