package com.github.satoshun.example.material.floatingactionbutton.extended

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.extended_floating_frag.*

class ExtendedFloatingButtonExampleFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.extended_floating_frag, container, false)
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
