package com.github.satoshun.example.material.floatingactionbutton

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.animation.MotionSpec
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.floating_action_button_act.*

class FloatingActionButtonActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.floating_action_button_act)

    var fabMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    fab.setOnClickListener {
      fabMode = (fabMode + 1) % 2
      bar.fabAlignmentMode = fabMode
    }

    fab.showMotionSpec = MotionSpec.createFromResource(
      this,
      R.animator.fab_show_motion_spec
//      com.google.android.material.R.animator.design_fab_show_motion_spec
    )
    fab.hideMotionSpec = MotionSpec.createFromResource(
      this,
      R.animator.fab_hide_motion_spec
//      com.google.android.material.R.animator.design_fab_hide_motion_spec
    )
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    return true
  }
}
