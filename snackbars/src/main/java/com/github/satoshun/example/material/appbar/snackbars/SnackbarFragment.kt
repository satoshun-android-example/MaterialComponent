package com.github.satoshun.example.material.appbar.snackbars

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
import com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.snackbar_frag.*

class SnackbarFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.snackbar_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    slide.setOnClickListener {
      Snackbar
        .make(view, "test", Snackbar.LENGTH_SHORT)
        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
        .setAction("ADD A NEW LABEL") {
        }
        .show()
    }

    fade.setOnClickListener {
      Snackbar
        .make(view, "test", Snackbar.LENGTH_SHORT)
        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE)
        .setAction("ADD A NEW LABEL") {
        }
        .show()
    }

    animationTest.setOnClickListener {
      val alphaAnimator = it.getAlphaAnimator(0f, 1f)
      val scaleAnimator = it.getScaleAnimator(0.8f, 1f)

      val animatorSet = AnimatorSet()
      animatorSet.playTogether(alphaAnimator, scaleAnimator)
      animatorSet.duration = 1500L
      animatorSet.addListener(
        object : AnimatorListenerAdapter() {
          override fun onAnimationEnd(animator: Animator) {
          }
        })
      animatorSet.start()
    }
  }
}

private fun View.getAlphaAnimator(vararg alphaValues: Float): ValueAnimator {
  val animator = ValueAnimator.ofFloat(*alphaValues)
  animator.interpolator = LINEAR_INTERPOLATOR
  animator.addUpdateListener { v ->
    alpha = v.animatedValue as Float
  }
  return animator
}

private fun View.getScaleAnimator(vararg scaleValues: Float): ValueAnimator {
  val animator = ValueAnimator.ofFloat(*scaleValues)
  animator.interpolator = LINEAR_OUT_SLOW_IN_INTERPOLATOR
  animator.addUpdateListener { v ->
    val scale = v.animatedValue as Float
    scaleX = scale
    scaleY = scale
  }
  return animator
}
