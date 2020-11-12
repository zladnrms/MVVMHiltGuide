package  com.tistory.zladnrms.mvvmhiltguide.model.entity.todo

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "todo")
data class Memo (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long?,

    @ColumnInfo(name = "content")
    var content: String? = null,

    @ColumnInfo(name = "created_at")
    var createdAt: Long? = null
) {
    constructor(): this(null, null, null)
}