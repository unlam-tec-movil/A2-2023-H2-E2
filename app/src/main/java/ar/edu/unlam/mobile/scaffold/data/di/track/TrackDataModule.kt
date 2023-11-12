package ar.edu.unlam.mobile.scaffold.data.di.track

import ar.edu.unlam.mobile.scaffold.data.network.track.TrackHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.network.track.TrackNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.repository.track.TrackDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.repository.track.TrackRepository
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
