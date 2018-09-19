package com.github.satoshun.example.material.appbar.chips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ChipActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.chip_act)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, ChipFragment())
          .commit()
    }
  }
}
