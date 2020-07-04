package luv.zoey.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    // 각각의 속성들을 조건을 오름차순대로 조회
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    // 각각의 속성들의 Total을 조회
    @Query("SELECT SUM(timeInMillis) FROM RUNNING_TABLE")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM RUNNING_TABLE")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM RUNNING_TABLE")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM RUNNING_TABLE")
    fun getTotalAvgSpeed(): LiveData<Float>
}