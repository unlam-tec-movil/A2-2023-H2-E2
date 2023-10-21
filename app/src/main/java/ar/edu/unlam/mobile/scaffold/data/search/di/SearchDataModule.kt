package ar.edu.unlam.mobile.scaffold.data.search.di

import ar.edu.unlam.mobile.scaffold.data.search.network.SearchHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.search.network.SearchNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.search.repository.SearchAPIRepository
import ar.edu.unlam.mobile.scaffold.data.search.repository.SearchRepository
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
