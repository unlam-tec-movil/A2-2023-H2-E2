package ar.edu.unlam.mobile.scaffold.domain.di.authorization

import ar.edu.unlam.mobile.scaffold.domain.services.authorization.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.domain.services.authorization.AuthorizationService
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
