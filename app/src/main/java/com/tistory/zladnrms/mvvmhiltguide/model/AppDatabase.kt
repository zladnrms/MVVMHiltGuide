package  com.tistory.zladnrms.mvvmhiltguide.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tistory.zladnrms.mvvmhiltguide.model.dao.MemoDao
import com.tistory.zladnrms.mvvmhiltguide.model.entity.todo.Memo


@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {
        const val DATABASE_NAME = "mvvmhiltguide-db"

        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}