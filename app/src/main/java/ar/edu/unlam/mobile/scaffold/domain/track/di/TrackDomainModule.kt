package ar.edu.unlam.mobile.scaffold.domain.track.di

import ar.edu.unlam.mobile.scaffold.domain.track.services.TrackGetter
import ar.edu.unlam.mobile.scaffold.domain.track.services.TrackService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TrackDomainModule {

    @Binds
    abstract fun bindTrackUseCase(trackUseCaseImpl: TrackService): TrackGetter
}
