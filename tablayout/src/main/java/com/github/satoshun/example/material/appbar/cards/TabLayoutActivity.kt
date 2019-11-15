package com.github.satoshun.example.material.appbar.cards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TabLayoutActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tab_layout_act)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, CardFragment())
          .commit()
    }
  }
}
