package com.github.satoshun.example.material.appbar.sliders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SliderActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.slider_act)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, SliderFragment())
          .commit()
    }
  }
}
