package com.github.satoshun.example.material.appbar.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
      activity!!.supportFragmentManager
          .beginTransaction()
          .replace(R.id.container, AppbarBottom2Fragment(), "this")
          .addToBackStack("this")
          .commit()
    }

    bottomAppBar.setNavigationIcon(R.drawable.ic_menu_24)
    bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    bottomAppBar.replaceMenu(R.menu.frag1)
  }
}
