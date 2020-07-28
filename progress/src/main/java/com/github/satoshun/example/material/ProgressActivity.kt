package com.github.satoshun.example.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProgressActivity : AppCompatActivity(R.layout.progress_act) {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(R.id.container, ProgressFragment())
        .commit()
    }
  }
}
