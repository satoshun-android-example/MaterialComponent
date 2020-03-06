package com.github.satoshun.example.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShapeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.shape_act)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, ShapeFragment())
        .commit()
    }
  }
}
