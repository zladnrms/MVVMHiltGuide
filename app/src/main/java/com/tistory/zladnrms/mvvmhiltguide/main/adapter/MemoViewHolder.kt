package com.tistory.zladnrms.mvvmhiltguide.main.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tistory.zladnrms.mvvmhiltguide.databinding.MemoListItemBinding
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo

class MemoViewHolder(private val binding: MemoListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("RtlHardcoded")
    fun bind(item: Memo, onClick: () -> Unit) {
        with(item) {
            binding.item = this
        }

        itemView.setOnClickListener {
            onClick()
        }
    }
}