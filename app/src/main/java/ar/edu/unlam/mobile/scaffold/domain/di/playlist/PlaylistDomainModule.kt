package ar.edu.unlam.mobile.scaffold.domain.di.playlist

import ar.edu.unlam.mobile.scaffold.domain.services.playlist.PlaylistGetter
import ar.edu.unlam.mobile.scaffold.domain.services.playlist.PlaylistService
import ar.edu.unlam.mobile.scaffold.domain.services.playlist.PlaylistSetter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PlaylistDomainModule {

    @Binds
    abstract fun bindsPlaylistServiceGetterUseCase(playlistService: PlaylistService): PlaylistGetter

    @Binds
    abstract fun bindsPlaylistServiceSetterUseCase(playlistService: PlaylistService): PlaylistSetter
}
