package com.github.satoshun.example.material.datepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DatePickerActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.date_picker_act)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, DatePickerFragment())
        .commit()
    }
  }
}
