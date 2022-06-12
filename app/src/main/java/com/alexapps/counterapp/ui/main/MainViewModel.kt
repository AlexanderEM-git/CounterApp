package com.alexapps.counterapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

class MainViewModel: ViewModel() {


    private  var suma = 0

    //tipo de dato que puede ser observado por fuera de la actividad afuera
    private val counter: MutableLiveData<Int> = MutableLiveData()
    val counterDone: LiveData<Int> = counter

    //tipo de dato que puede ser observado por fuera de la actividad afuera
    private val enablePlus: MutableLiveData<Boolean> = MutableLiveData()
    val enableplusDone: LiveData<Boolean> = enablePlus

    //tipo de dato que puede ser observado por fuera de la actividad afuera
    private val enableSubtract: MutableLiveData<Boolean> = MutableLiveData()
    val enableSubtractDone: LiveData<Boolean> = enableSubtract


    //funciones para trabajar
    fun sumeContador() {
        suma ++
        counter.value = suma    // cuanto se suma, a couter le cambiamos el valor y puede ser visto mediante conuterdone
    }

    fun resteContador() {
        suma --
        counter.value = suma
    }

    fun probarContador(){
        enablePlus.value = suma != 999
        enableSubtract.value = suma != 0
    }

    fun reniciarContador() {
        suma = 0
        counter.value = suma
        enableSubtract.value = suma != 0
    }

}