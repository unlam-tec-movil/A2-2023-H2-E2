package ar.edu.unlam.mobile.scaffold.data.track.di

import ar.edu.unlam.mobile.scaffold.data.track.network.TrackHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.track.network.TrackNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.track.repository.TrackDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.track.repository.TrackRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TrackDataModule {
    @Binds
    abstract fun bindTrackRepository(trackRepositoryImpl: TrackDefaultRepository): TrackRepository

    @Binds
    abstract fun bindTrackNetworkRepo(trackHTTPClient: TrackHTTPRepository): TrackNetworkRepository
}
