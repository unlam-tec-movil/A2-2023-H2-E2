package ar.edu.unlam.mobile.scaffold.domain.di.search

import ar.edu.unlam.mobile.scaffold.domain.services.search.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.services.search.SearchService
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
