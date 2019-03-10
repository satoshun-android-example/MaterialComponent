package com.github.satoshun.example.material.floatingactionbutton.extended

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.extended_floating_act.*

class ExtendedFloatingButtonExampleActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.extended_floating_act)
    setSupportActionBar(toolbar)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, ExtendedFloatingButtonExampleFragment())
        .commit()
    }

    fab.setOnClickListener {
      println("test")
    }
  }
}
