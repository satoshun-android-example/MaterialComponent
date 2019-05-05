package com.github.satoshun.example.material.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheets_layout2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.bottomsheets_layout2, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val adapter = AdapterSample { self ->
      submit.isEnabled = self.isCheckBoxed()
      checked_number.text = self.checkboxedItemIds().size.toString()
    }
    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(context!!)

    GlobalScope.launch(Dispatchers.Main) {
      adapter.populateItems()
    }

    submit.setOnClickListener {
      GlobalScope.launch(Dispatchers.Main) {
        progress.isVisible = true
        postIds(adapter.checkboxedItemIds())
        progress.isVisible = false
        dismiss()
      }
    }
  }
}
