package ar.edu.unlam.mobile.scaffold.domain.authorization.di

import ar.edu.unlam.mobile.scaffold.domain.authorization.services.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.domain.authorization.services.AuthorizationService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthorizationDomainModule {

    @Binds
    abstract fun bindAuthorizationUseCase(authorizationUseCaseImpl: AuthorizationService): AuthorizationGetter
}
