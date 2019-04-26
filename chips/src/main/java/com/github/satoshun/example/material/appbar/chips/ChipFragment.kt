package com.github.satoshun.example.material.appbar.chips

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.chip.Chip
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

    editable.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        editable_chip.text = editable.editableText.toString()
        editable_chip.visibility = View.VISIBLE
        editable.visibility = View.GONE
        true
      } else {
        false
      }
    }
    editable_chip.setOnClickListener {
      it.postDelayed(50) {
        editable_chip.visibility = View.GONE
        editable.visibility = View.VISIBLE
      }
    }

    spannable1.setTextWithNumber("Hello", 1000)

    val icon = filter_chip1.checkedIcon!!.mutate()
    icon.setTint(ContextCompat.getColor(activity!!, R.color.colorPrimary))
    filter_chip1.checkedIcon = icon

    // TODO
    filter_chip1.setShowMotionSpecResource(R.animator.test_animator)
    filter_chip1.setHideMotionSpecResource(R.animator.test_animator)

    recycler.adapter = ChipAdapter()
    recycler.layoutManager = StaggeredGridLayoutManager(
      2,
      StaggeredGridLayoutManager.HORIZONTAL
    )
  }
}

fun Chip.setTextWithNumber(text: String, number: Long) {
  val span = SpannableString(text + number.toString())
  span.setSpan(
//    StyleSpan(R.style.TextAppearance_MaterialComponents_Headline1),
    AbsoluteSizeSpan(16, true),
    0,
    text.length,
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
  )
  span.setSpan(
    AbsoluteSizeSpan(10, true),
    text.length,
    text.length + number.toString().length,
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
  )

  setText(span)
}
