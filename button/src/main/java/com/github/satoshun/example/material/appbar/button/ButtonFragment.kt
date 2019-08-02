package com.github.satoshun.example.material.appbar.button

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ButtonFragment : BaseFragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View =
    inflater.inflate(
      R.layout.button_frag,
      container,
      false
    )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
