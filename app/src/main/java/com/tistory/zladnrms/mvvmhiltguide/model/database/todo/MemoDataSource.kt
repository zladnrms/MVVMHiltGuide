package  com.tistory.zladnrms.mvvmhiltguide.model.database.todo

import androidx.sqlite.db.SupportSQLiteQuery
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo

interface MemoDataSource {
    suspend fun getList() : MutableList<Memo>

    suspend fun get(uid: Long) : Memo

    fun insert(todo: Memo)

    fun delete()

    fun vacuumDb(supportSQLiteQuery: SupportSQLiteQuery)
}