package com.github.satoshun.example.material.textfield

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.endIconView

class TextFieldActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.material_text_field)

    val basic = findViewById<TextInputLayout>(R.id.basic)
    basic.endIconView().scaleX = 0.5f
    basic.endIconView().scaleY = 0.5f

    val circle = findViewById<TextInputLayout>(R.id.circle)
//    val drawable = getDrawable(R.drawable.ic_android_black_24dp)
//    circle.startIconDrawable = ScaleDrawable(drawable, Gravity.BOTTOM, 0.9f, 0.9f)
//    circle.startIconDrawable = getDrawable(R.drawable.ic_android_black_24dp)
  }
}
