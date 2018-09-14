package com.github.satoshun.example.material.appbar.bottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AppbarBottomActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.appbar_bottom_act)

    val fragment = AppbarBottom1Fragment()
    supportFragmentManager
        .beginTransaction()
        .add(R.id.container, fragment)
        .commit()
  }
}
