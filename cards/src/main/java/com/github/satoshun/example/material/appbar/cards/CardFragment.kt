package com.github.satoshun.example.material.appbar.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.github.satoshun.coroutinebinding.view.click
import kotlinx.android.synthetic.main.card_frag.*
import kotlinx.coroutines.experimental.launch

class CardFragment : BaseFragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.card_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    launch {
      while (true) {
        expand.click()
        expand.isGone = true

        expanded_title.isVisible = true
        collapse.isVisible = true
        action_group.isVisible = true
      }
    }

    launch {
      while (true) {
        collapse.click()
        expanded_title.isGone = true
        collapse.isGone = true
        action_group.isGone = true

        expand.isVisible = true
      }
    }
  }
}
