package at.interview.ohanaassignment.usage.domain.di

import at.interview.ohanaassignment.usage.data.repository.UsageRepo
import at.interview.ohanaassignment.usage.data.repository.UsageRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsageRepo(): UsageRepo {
        return UsageRepoImpl()
    }
}