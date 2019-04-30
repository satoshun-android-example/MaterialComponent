package com.github.satoshun.example.material.floatingactionbutton

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class FloatingActionButtonActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.floating_action_button_act)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    return true
  }
}
