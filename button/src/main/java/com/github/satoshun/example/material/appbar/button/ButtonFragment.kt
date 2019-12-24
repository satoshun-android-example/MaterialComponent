package com.github.satoshun.example.material.appbar.button

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.button_frag.*

class ButtonFragment : Fragment(R.layout.button_frag) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    Glide
      .with(this)
      .load("https://pbs.twimg.com/profile_images/1188611587243827200/2G40JGK5_400x400.jpg")
      .into(diamond)
  }
}
