package com.tistory.zladnrms.mvvmhiltguide.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tistory.zladnrms.mvvmhiltguide.R
import com.tistory.zladnrms.mvvmhiltguide.databinding.MainActivityBinding
import com.tistory.zladnrms.mvvmhiltguide.main.adapter.MemoListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var memoListAdapter:  MemoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        memoListAdapter = MemoListAdapter(
            onAdd = {

            }
        )

        with(binding.recyclerView) {
            hasFixedSize()
            this.adapter = memoListAdapter
            itemAnimator = null
        }
    }
}