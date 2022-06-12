package com.alexapps.counterapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.alexapps.counterapp.R
import com.alexapps.counterapp.ui.settings.SettingsActivity
import com.alexapps.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding //colocado la actividad principal

    //private lateinit var mainViewModel: MainViewModel //creo Viewmodel

    private  var suma = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)//colocado la actividad principal
        val view = mainBinding.root //colocado la actividad principal
        setContentView(view)


        //Parte del view model

        //mainViewModel = ViewModelProvider(this)[mainViewModel::class.java]// vinculo a la actividad Viewmodel

        //observadores de os live data

        //mainViewModel.counterDone.observe(this){ counter ->
        //    mainBinding.countTextView.text = counter.toString()
        //}

        //mainViewModel.enableplusDone.observe(this){ enableplus ->
        //    mainBinding.plusButton.isEnabled = isEnabled
        //}

        //mainViewModel.enableSubtractDone.observe(this){ enableSubtract ->
        //    mainBinding.minusButtom.isEnabled = isEnabled
        //}



        with(mainBinding){
            plusButton.setOnClickListener {
                //mainViewModel.sumeContador()// llamo la funcion en el otro archivo
                //mainViewModel.probarContador()

               suma++
               countTextView.text = suma.toString()
               probarsuma(suma)
            }
            minusButtom.setOnClickListener {
                //mainViewModel.resteContador()
                //mainViewModel.probarContador()

                suma--
                countTextView.text = suma.toString()
                probarsuma(suma)
            }
        }
    }

    private fun probarsuma(suma: Int) {

        mainBinding.minusButtom.isEnabled = suma !=0
        mainBinding.plusButton.isEnabled = suma != 999
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // ponemos el menu
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // si se toca el boton de configuracion se va a la actividad
        when(item.itemId){// si toco configuracion o el otro
            R.id.menu_settings -> irActividadConfiguracion()
            else -> {
                //mainViewModel.reniciarContador()
                mainBinding.minusButtom.isEnabled = false

                suma = 0
                mainBinding.countTextView.text = suma.toString()
                mainBinding.minusButtom.isEnabled = false
            }
        }

        //if(item.itemId == R.id.menu_settings){ irActividadConfiguracion() } // otra forma de ir a configuracion
        return true
    }

    private fun irActividadConfiguracion() {
        val intent =
            Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}