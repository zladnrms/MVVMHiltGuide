package com.tistory.zladnrms.mvvmhiltguide.main.data

import androidx.annotation.IntDef


@Retention(AnnotationRetention.SOURCE)
@IntDef(MemoCategoryType.TYPE_VIEW, MemoCategoryType.TYPE_ADD)
annotation class MemoCategoryType {
    companion object {
        const val TYPE_VIEW = 0
        const val TYPE_ADD = 1
    }
}