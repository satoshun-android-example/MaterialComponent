package com.github.satoshun.example.material.appbar.banners

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.banner_act.*

class BannerActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.banner_act)
    setSupportActionBar(toolbar)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, BannerFragment())
          .commit()
    }
  }
}
