package ar.edu.unlam.mobile.scaffold.data.authorization.di

import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.authorization.repository.AuthorizationDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.authorization.repository.AuthorizationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthorizationDataModule {
    @Binds
    abstract fun bindAuthorizationRepository(authorizationRepositoryImpl: AuthorizationDefaultRepository): AuthorizationRepository

    @Binds
    abstract fun bindAuthorizationNetworkRepo(authorizationHTTPClient: AuthorizationHTTPRepository): AuthorizationNetworkRepository
}
