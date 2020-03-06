package com.github.satoshun.example.material

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
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
  }

  private fun createTooltipBackground(): Drawable {
    val model = ShapeAppearanceModel.Builder()
      .setAllCornerSizes(AbsoluteCornerSize(32f))
      .setBottomEdge(ArrowBottomEdgeTreatment())
      .build()
    val drawable = MaterialShapeDrawable(model).apply {
      fillColor = ColorStateList.valueOf(Color.GREEN)
      setPadding(32, 32, 32, 32)
    }
    return drawable
  }
}

class ArrowBottomEdgeTreatment : EdgeTreatment() {
  override fun getEdgePath(length: Float, center: Float, interpolation: Float, shapePath: ShapePath) {
    shapePath.lineTo(100f, 0f)
    shapePath.lineTo(100f, -50f)
    shapePath.lineTo(150f, 0f)
    shapePath.lineTo(length, 0f)
  }
}
