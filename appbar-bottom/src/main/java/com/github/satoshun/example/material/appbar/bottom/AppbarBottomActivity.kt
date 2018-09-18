package com.github.satoshun.example.material.appbar.bottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.appbar_bottom_act.*

class AppbarBottomActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.appbar_bottom_act)
    setSupportActionBar(bar)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, AppbarBottom1Fragment())
          .commit()
    }
  }
}
