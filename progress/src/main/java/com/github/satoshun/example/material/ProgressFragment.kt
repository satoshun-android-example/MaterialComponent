package com.github.satoshun.example.material

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.material.databinding.ProgressFragBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressFragment : Fragment(R.layout.progress_frag) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val binding: ProgressFragBinding = ProgressFragBinding.bind(view)

    var progress = 0
    viewLifecycleOwner.lifecycleScope.launch {
      while (progress <= 100) {
        progress += 1
        binding.progress2.setProgressCompat(progress, true)
        delay(100)
      }
    }
  }
}
