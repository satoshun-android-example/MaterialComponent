package com.github.satoshun.example.material.appbar.snackbars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SnackbarActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.snackbar_act)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, SnackbarFragment())
          .commit()
    }
  }
}
