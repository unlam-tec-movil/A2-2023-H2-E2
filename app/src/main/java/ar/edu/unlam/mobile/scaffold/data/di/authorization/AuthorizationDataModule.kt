package ar.edu.unlam.mobile.scaffold.data.di.authorization

import ar.edu.unlam.mobile.scaffold.data.network.authorization.AuthorizationHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.network.authorization.AuthorizationNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.repository.authorization.AuthorizationDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.repository.authorization.AuthorizationRepository
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
