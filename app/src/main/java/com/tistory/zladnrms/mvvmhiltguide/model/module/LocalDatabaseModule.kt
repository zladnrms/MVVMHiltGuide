package  com.tistory.zladnrms.mvvmhiltguide.model.module

import android.content.Context
import com.tistory.zladnrms.mvvmhiltguide.model.AppDatabase
import com.tistory.zladnrms.mvvmhiltguide.model.database.todo.MemoDataSource
import com.tistory.zladnrms.mvvmhiltguide.model.database.todo.MemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object LocalDataBaseModule {
    @Provides
    @Singleton
    fun provideMemoRepository(context: Context): MemoDataSource =
        MemoRepository.getInstance(AppDatabase.getInstance(context).memoDao())
}