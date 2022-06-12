package com.alexapps.counterapp.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexapps.counterapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var settingsBinding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        settingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = settingsBinding.root
        setContentView(view)

        // puedo asignar el valor maximo del contador

    }
}





