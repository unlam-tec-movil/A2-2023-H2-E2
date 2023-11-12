package ar.edu.unlam.mobile.scaffold.data.di.search

import ar.edu.unlam.mobile.scaffold.data.network.search.SearchHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.network.search.SearchNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.repository.search.SearchAPIRepository
import ar.edu.unlam.mobile.scaffold.data.repository.search.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchDataModule {

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImplementation: SearchAPIRepository): SearchRepository

    @Binds
    abstract fun bindSearchNetworkRepository(searchNetworkRepositoryClient: SearchHTTPRepository): SearchNetworkRepository
}
