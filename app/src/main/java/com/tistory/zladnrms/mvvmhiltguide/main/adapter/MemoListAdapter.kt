package com.tistory.zladnrms.mvvmhiltguide.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tistory.zladnrms.mvvmhiltguide.databinding.MemoListItemBinding
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MemoListAdapter constructor(
    private val onAdd: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Memo>()

    init {
        setHasStableIds(true)
    }

    fun updateList(list: List<Memo>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MemoViewHolder -> {
                holder.bind(items[position], onAdd)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MemoListItemBinding.inflate(inflater, parent, false)
        return MemoViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].hashCode().toLong()
}