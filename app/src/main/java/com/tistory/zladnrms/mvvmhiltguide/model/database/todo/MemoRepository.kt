package  com.tistory.zladnrms.mvvmhiltguide.model.database.todo

import androidx.sqlite.db.SupportSQLiteQuery
import com.tistory.zladnrms.mvvmhiltguide.model.dao.MemoDao
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo


class MemoRepository private constructor(private val todoDao: MemoDao) : MemoDataSource {

    override suspend fun getList() : MutableList<Memo> = todoDao.getList()

    override suspend fun get(uid: Long) : Memo = todoDao.get(uid)

    override fun insert(todo: Memo) {
        todoDao.insert(todo)
    }

    override fun delete() {
        todoDao.delete()
    }

    override fun vacuumDb(supportSQLiteQuery: SupportSQLiteQuery) {
        todoDao.vacuumDb(supportSQLiteQuery)
    }

    companion object {

        @Volatile
        private var instance: MemoRepository? = null

        fun getInstance(todoDao: MemoDao) =
            instance
                ?: synchronized(this) {
                instance
                    ?: MemoRepository(
                        todoDao
                    )
                        .also { instance = it }
            }
    }
}