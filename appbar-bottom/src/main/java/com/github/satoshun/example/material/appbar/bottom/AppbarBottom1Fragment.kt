package com.github.satoshun.example.material.appbar.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.behavior.SwipeDismissBehavior
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.appbar_bottom1_frag.*

class AppbarBottom1Fragment : Fragment() {
  private val bottomAppBar: BottomAppBar get() = activity!!.findViewById(R.id.bar)
  private val fab: FloatingActionButton get() = activity!!.findViewById(R.id.fab)

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.appbar_bottom1_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    button.setOnClickListener {
      fab.hide()

      activity!!
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, AppbarBottom2Fragment(), "this")
        .addToBackStack("this")
        .commit()
    }

    // todo snackbar upper fab button
    button2.setOnClickListener {
      val snackbar = Snackbar.make(rootView, "snackbar", Snackbar.LENGTH_SHORT)
      val snackbarView = snackbar.view
      val params = snackbarView.layoutParams as ViewGroup.MarginLayoutParams
      params.setMargins(
        params.leftMargin,
        params.topMargin,
        params.rightMargin,
        params.bottomMargin
      )
      snackbarView.layoutParams = params
      snackbar.show()

      snackbar.behavior = BaseTransientBottomBar.Behavior().apply {
        setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY)
      }
    }

    // todo use FloatingActionButton.OnVisibilityChangedListener
    view.postDelayed({
      bottomAppBar.setNavigationIcon(R.drawable.ic_menu_24)
      bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
      bottomAppBar.replaceMenu(R.menu.frag1)

      fab.show()
    }, 100)
  }
}
