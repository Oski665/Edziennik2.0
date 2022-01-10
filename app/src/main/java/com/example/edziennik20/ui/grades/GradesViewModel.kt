package com.example.edziennik20.ui.grades

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GradesViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tu som ocenki"
    }
    val text: LiveData<String> = _text
}