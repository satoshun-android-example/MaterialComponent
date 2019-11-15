package com.github.satoshun.example.material.appbar.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.github.satoshun.coroutinebinding.view.awaitClick
import kotlinx.android.synthetic.main.card_frag.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    GlobalScope.launch {
      while (true) {
        expand.awaitClick()
        expand.isGone = true

        expanded_title.isVisible = true
        collapse.isVisible = true
        action_group.isVisible = true
      }
    }

    GlobalScope.launch {
      while (true) {
        collapse.awaitClick()
        expanded_title.isGone = true
        collapse.isGone = true
        action_group.isGone = true

        expand.isVisible = true
      }
    }
  }
}
