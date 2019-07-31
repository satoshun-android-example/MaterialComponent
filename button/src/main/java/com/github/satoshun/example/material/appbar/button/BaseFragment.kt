package com.github.satoshun.example.material.appbar.button

import android.content.Context
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(), CoroutineScope {
  private lateinit var job: Job

  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

  override fun onAttach(context: Context) {
    super.onAttach(context)
    job = Job()
  }

  override fun onDestroy() {
    job.cancel()
    super.onDestroy()
  }
}
