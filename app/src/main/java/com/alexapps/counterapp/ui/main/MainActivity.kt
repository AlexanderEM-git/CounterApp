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

    private lateinit var viewModel: MainViewModel //creo Viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)//colocado la actividad principal
        val view = mainBinding.root //colocado la actividad principal
        setContentView(view)

        //Parte del view mode
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // vinculo a la actividad Viewmode observadores de os live dat

        viewModel.counterDone.observe(this){ counter ->
            mainBinding.countTextView.text = counter.toString()
        }

        viewModel.enableplusDone.observe(this) { enableplus ->
            mainBinding.plusButton.isEnabled = enableplus
        }

        viewModel.enableSubtractDone.observe(this){ enableSubtract ->
            mainBinding.minusButtom.isEnabled = enableSubtract
        }



        with(mainBinding){
            plusButton.setOnClickListener {
                viewModel.sumeContador()// llamo la funcion en el otro archivo
                viewModel.probarContador()
            }
            minusButtom.setOnClickListener {
                viewModel.resteContador()
                viewModel.probarContador()
            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // ponemos el menu
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // si se toca el boton de configuracion se va a la actividad
        when(item.itemId){// si toco configuracion o el otro
            R.id.menu_settings -> irActividadConfiguracion()
            else -> {
                viewModel.reniciarContador()
                viewModel.probarContador()
            }
        }
        return true
    }

    private fun irActividadConfiguracion() {
        val intent =
            Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}