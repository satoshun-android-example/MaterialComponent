package com.github.satoshun.example.material.textfield

import android.graphics.drawable.AnimatedStateListDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class TextFieldActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.material_text_field)

    val basic = findViewById<TextInputLayout>(R.id.basic)
    val endIcon = basic.endIconDrawable as AnimatedStateListDrawable

    endIcon.setBounds(0, 0, 0, 0)

//    val scale = ScaleDrawable(
//      endIcon,
//      Gravity.CENTER,
//      1f,
//      1f
//    )
//    scale.level = 10000

//    endIcon.setBounds(
//      0,
//      10,
//      (endIcon.intrinsicWidth * 0.3).toInt(),
//      (endIcon.intrinsicHeight * 0.3).toInt()
//    )
//    basic.invalidateDrawable(endIcon)

    basic.endIconDrawable = endIcon
  }
}
