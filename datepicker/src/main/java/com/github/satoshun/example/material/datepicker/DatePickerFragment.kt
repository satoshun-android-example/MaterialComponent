package com.github.satoshun.example.material.datepicker

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.github.satoshun.coroutinebinding.view.awaitClick
import kotlinx.android.synthetic.main.date_picker_frag.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.min

class DatePickerFragment : BaseFragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.date_picker_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    launch {
      while (true) {
        time_picker.awaitClick()
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(
          activity,
          0,
          TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            // todo
          },
          hour,
          minute,
          false
        )
        dialog.show()
      }
    }
  }
}
