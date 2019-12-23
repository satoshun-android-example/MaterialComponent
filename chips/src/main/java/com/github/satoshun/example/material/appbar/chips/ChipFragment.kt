package com.github.satoshun.example.material.appbar.chips

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.chip_frag.*

internal class ChipFragment : Fragment(R.layout.chip_frag) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    rootView.addView(
      Chip(requireContext(), null, R.style.Widget_Example_Chip_Small).apply {
        text = "test"
        layoutParams = ViewGroup.MarginLayoutParams(
          ViewGroup.LayoutParams.WRAP_CONTENT,
          ViewGroup.LayoutParams.WRAP_CONTENT
//          24.dpToPx(requireContext())
        )
//        chipMinHeight = 24.dpToPx(requireContext()).toFloat()
//        ensureAccessibleTouchTarget(24.dpToPx(requireContext()))
      },
      0
    )

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
    filter_chip1.setOnCheckedChangeListener { _, isChecked ->
      if (isChecked) {
        filter_chip1.chipStrokeWidth = 4.0f
        filter_chip1.chipStrokeColor = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.colorPrimary))
        filter_chip1.chipBackgroundColor = ColorStateList
          .valueOf(ContextCompat.getColor(context!!, R.color.colorPrimary))
          .withAlpha(10)
      } else {
        filter_chip1.chipStrokeWidth = 0f
      }
    }

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

@Px
fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()
