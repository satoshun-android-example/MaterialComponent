package com.github.satoshun.example.material.appbar.chips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.chip_act.*

class ChipBottomActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.chip_act)
    setSupportActionBar(bar)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, ChipFragment())
          .commit()
    }
  }
}
