package ar.edu.unlam.mobile.scaffold.domain.search.di

import ar.edu.unlam.mobile.scaffold.domain.search.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.search.service.SearchService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchDomainModule {

    @Binds
    abstract fun bindSearchUseCase(searchService: SearchService): SearchGetter
}
