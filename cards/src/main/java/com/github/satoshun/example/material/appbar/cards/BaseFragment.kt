package com.github.satoshun.example.material.appbar.cards

import android.content.Context
import androidx.fragment.app.Fragment
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

abstract class BaseFragment : Fragment(), CoroutineScope {
  private lateinit var job: Job

  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    job = Job()
  }

  override fun onDestroy() {
    job.cancel()
    super.onDestroy()
  }
}
