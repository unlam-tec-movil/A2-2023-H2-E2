package ar.edu.unlam.mobile.scaffold.domain.songs.di

import ar.edu.unlam.mobile.scaffold.domain.songs.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SearchService
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SongsGetter
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SongsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchDomainModule {

    @Binds
    abstract fun bindSearchUseCase(searchService: SearchService): SearchGetter

    @Binds
    abstract fun bindSongsGetter(searchService: SongsService): SongsGetter
}
