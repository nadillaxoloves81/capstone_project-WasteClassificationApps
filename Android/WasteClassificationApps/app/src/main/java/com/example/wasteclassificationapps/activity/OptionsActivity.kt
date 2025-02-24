package com.example.wasteclassificationapps.activity

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.SettingPreferences
import com.example.wasteclassificationapps.viewModel.SettingViewModel
import com.example.wasteclassificationapps.viewModel.SettingViewModelFactory
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.system.exitProcess


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        supportActionBar?.title = "Settings"

        val mButton = findViewById<ImageView>(R.id.btn_img_exit)
        mButton.setOnClickListener {
            val mBuilder = AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .show()
            val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
            mPositiveButton.setOnClickListener {
                exitProcess(0)
            }
        }

        val changeTheme = findViewById<SwitchMaterial>(R.id.change_theme)

        val pref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(this, SettingViewModelFactory(pref)).get(
            SettingViewModel::class.java
        )
        settingViewModel.getChangeThemeSetting().observe(this,
            { isDarkModeActive: Boolean ->
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    changeTheme.isChecked = true
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    changeTheme.isChecked = false
                }
            })

        changeTheme.setOnCheckedChangeListener {  _: CompoundButton?, isChecked: Boolean ->
            settingViewModel.saveChangeThemeSetting(isChecked)
        }

    }
}