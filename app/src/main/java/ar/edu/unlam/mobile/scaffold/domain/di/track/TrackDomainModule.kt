package ar.edu.unlam.mobile.scaffold.domain.di.track

import ar.edu.unlam.mobile.scaffold.domain.services.track.TrackGetter
import ar.edu.unlam.mobile.scaffold.domain.services.track.TrackService
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
