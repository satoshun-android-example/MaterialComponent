package com.github.satoshun.example.material.bottomsheets

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BottomSheetsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.bottomsheets_act)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.bottomsheets_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.title -> {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottomsheets_layout)
        dialog.findViewById<View>(R.id.title1)!!.setOnClickListener {
          val dialog2 = BottomSheetDialog(this)
          dialog2.setContentView(R.layout.bottomsheets_layout2)
          val displayMetrics = DisplayMetrics()
          this
            .windowManager
            .defaultDisplay
            .getMetrics(displayMetrics)
          val windowHeight = displayMetrics.heightPixels
          val modalBottomSheetChildView = dialog2.findViewById<View>(R.id.layout2_root)!!
          val layoutParams = modalBottomSheetChildView.layoutParams
          layoutParams.height = windowHeight
          modalBottomSheetChildView.layoutParams = layoutParams
          dialog2.behavior.peekHeight = windowHeight

          val toolbar = dialog2.findViewById<Toolbar>(R.id.toolbar)!!
          val close = dialog2.findViewById<View>(R.id.close)!!
          close.setOnClickListener {
            dialog2.dismiss()
          }

          val recycler = dialog2.findViewById<RecyclerView>(R.id.recycler)!!
          val adapter = AdapterSample()
          recycler.adapter = adapter
          recycler.layoutManager = LinearLayoutManager(this)

          val progress = dialog2.findViewById<ProgressBar>(R.id.progress)!!

          // todo global scope
          GlobalScope.launch(Dispatchers.Main) {
            progress.isVisible = true
            adapter.populateItems()
            progress.isVisible = false
          }

          val submit = dialog2.findViewById<Button>(R.id.submit)!!
          submit.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
              progress.isVisible = true
              postIds(adapter.checkboxedItemIds())
              progress.isVisible = false
              dialog2.dismiss()
            }
          }

          dialog2.show()
          dialog.dismiss()
        }
        dialog.show()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}

suspend fun postIds(ids: List<Int>) {
  delay(3000)
  // ...
}

class AdapterSample : GroupAdapter<ViewHolder>() {
  suspend fun populateItems() {
    delay(2000)
    addAll(
      (0..100).map { ItemSample(it) }
    )
  }

  fun checkboxedItemIds(): List<Int> {
    return (0 until itemCount).mapNotNull {
      (getItem(it) as? ItemSample)
        ?.takeIf { item -> item.isCheckboxed }
        ?.itemId
    }
  }

  fun isCheckBoxed(): Boolean {
    return checkboxedItemIds().isNotEmpty()
  }
}

class ItemSample(
  val itemId: Int
) : Item<ViewHolder>() {

  var isCheckboxed: Boolean = false
    private set

  override fun getLayout(): Int = R.layout.bottomsheets_item

  override fun bind(viewHolder: ViewHolder, position: Int) {
    viewHolder.root.findViewById<TextView>(R.id.title).text = id.toString()
    viewHolder.root.findViewById<CheckBox>(R.id.checkbox).isChecked = isCheckboxed
    viewHolder.root.findViewById<CheckBox>(R.id.checkbox).setOnCheckedChangeListener { _, isChecked ->
      this.isCheckboxed = isChecked
    }
  }
}
