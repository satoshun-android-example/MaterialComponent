package com.github.satoshun.example.material.appbar.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.card_frag.*

class CardFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.card_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    expand.setOnClickListener {
      expand.isGone = true

      expanded_title.isVisible = true
      collapse.isVisible = true
      action_group.isVisible = true
    }
    collapse.setOnClickListener {
      expanded_title.isGone = true
      collapse.isGone = true
      action_group.isGone = true

      expand.isVisible = true
    }
  }
}
