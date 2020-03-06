package com.github.satoshun.example.material

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.material.databinding.ShapeFragBinding
import com.google.android.material.shape.*

class ShapeFragment : Fragment(R.layout.shape_frag) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val binding = ShapeFragBinding.bind(view)

    binding.shape.background = createTooltipBackground()
    binding.inset.background = InsetDrawable(createTooltipBackground(), 0, 50, 0, 50)
  }

  private fun createTooltipBackground(): Drawable {
    val model = ShapeAppearanceModel.Builder()
      .setAllCornerSizes(AbsoluteCornerSize(32f))
      .setTopEdge(ArrowTopEdgeTreatment())
      .setBottomEdge(ArrowBottomEdgeTreatment())
      .build()
    val drawable = MaterialShapeDrawable(model).apply {
      fillColor = ColorStateList.valueOf(Color.GREEN)
      setPadding(32, 32, 32, 32)
    }
    return drawable
  }
}

private const val ARROW_HEIGHT = 40f

class ArrowBottomEdgeTreatment : EdgeTreatment() {
  override fun getEdgePath(length: Float, center: Float, interpolation: Float, shapePath: ShapePath) {
    shapePath.lineTo(100f, 0f)
    shapePath.lineTo(100f + ARROW_HEIGHT / 2, -ARROW_HEIGHT)
    shapePath.lineTo(100f + ARROW_HEIGHT, 0f)
    shapePath.lineTo(length, 0f)
  }
}

class ArrowTopEdgeTreatment : EdgeTreatment() {
  override fun getEdgePath(length: Float, center: Float, interpolation: Float, shapePath: ShapePath) {
    shapePath.lineTo(100f, 0f)
    shapePath.lineTo(100f + ARROW_HEIGHT / 2, -ARROW_HEIGHT)
    shapePath.lineTo(100f + ARROW_HEIGHT, 0f)
    shapePath.lineTo(length, 0f)
  }
}
