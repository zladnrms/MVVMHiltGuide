package  com.tistory.zladnrms.mvvmhiltguide.model.dao

import androidx.annotation.Keep
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo


@Keep
@Dao
interface MemoDao {

    @Query("SELECT * FROM todo ORDER BY id ASC")
    suspend fun getList(): MutableList<Memo>

    @Query("SELECT * FROM todo WHERE id = :uid")
    suspend fun get(uid: Long) : Memo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Memo)

    @Query("DELETE FROM todo;")
    fun delete()

    @RawQuery
    fun vacuumDb(supportSQLiteQuery: SupportSQLiteQuery) : Int
}