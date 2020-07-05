package luv.zoey.runningapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import luv.zoey.runningapp.db.RunningDatabase
import luv.zoey.runningapp.other.Constants.RUNNING_DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class) //이 한줄로는 싱글턴이 되지 않는다.
object AppModule {

    @Singleton  // 싱글턴 설정정
    @Provides
    fun provieRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provieRunDao(db: RunningDatabase) = db.getRunDao()
}