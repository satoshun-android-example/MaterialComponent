package com.github.satoshun.example.material.appbar.banners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.banner_frag.*

class BannerFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.banner_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    fix_it.setOnClickListener {
      (banner.parent as ViewGroup).removeView(banner)
    }

    learn_button.setOnClickListener {
      (banner.parent as ViewGroup).removeView(banner)
    }
  }
}
