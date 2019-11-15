package com.github.satoshun.example.material.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.example.material.tablayout.TabLayoutFragment

class TabLayoutActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tab_layout_act)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, TabLayoutFragment())
        .commit()
    }
  }
}
