package ar.edu.unlam.mobile.scaffold.data.token.di

import ar.edu.unlam.mobile.scaffold.data.token.repository.RepositoryImpl
import ar.edu.unlam.mobile.scaffold.data.token.repository.TokenPreferenceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PreferenceRepository {

    @Binds
    abstract fun provideRepository(impl: RepositoryImpl): TokenPreferenceRepository
}
