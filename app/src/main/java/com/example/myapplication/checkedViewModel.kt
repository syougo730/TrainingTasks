package com.example.myapplication

import androidx.lifecycle.ViewModel

/**
 * チェック状態を管理するVM
 */
class CheckedViewModel: ViewModel() {
    var checkbox1 : Boolean = false
    var checkbox2 : Boolean = false
}