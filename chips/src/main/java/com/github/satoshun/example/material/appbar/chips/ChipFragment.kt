package com.github.satoshun.example.material.appbar.chips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.chip_frag.*

class ChipFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.chip_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    input_chip1.setOnCloseIconClickListener {
      input_groups.removeView(input_chip1)
    }
    input_chip2.setOnCloseIconClickListener {
      input_groups.removeView(input_chip2)
    }
  }
}
