package com.github.satoshun.example.material.appbar.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ButtonActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.button_act)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, ButtonFragment())
        .commit()
    }
  }
}
