package ar.edu.unlam.mobile.scaffold.data.di.playlist

import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepository
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PlaylistDataModule {
    @Binds
    abstract fun playlistDataProvider(playlistImplementation: PlaylistRepository): PlaylistRepositoryInterface
}
