package ar.edu.unlam.mobile.scaffold.data.songs.di

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.songs.repository.SongsAPIRepository
import ar.edu.unlam.mobile.scaffold.data.songs.repository.SongsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchDataModule {

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImplementation: SongsAPIRepository): SongsRepository

    @Binds
    abstract fun bindSearchNetworkRepository(searchNetworkRepositoryClient: SongsHTTPRepository): SongsNetworkRepository
}
