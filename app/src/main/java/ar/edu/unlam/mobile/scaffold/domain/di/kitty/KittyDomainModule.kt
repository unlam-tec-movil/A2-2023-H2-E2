package ar.edu.unlam.mobile.scaffold.domain.di.kitty

import ar.edu.unlam.mobile.scaffold.domain.services.kitty.KittyGetter
import ar.edu.unlam.mobile.scaffold.domain.services.kitty.KittyService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KittyDomainModule {

    @Binds
    abstract fun bindKittyUseCase(kittyUseCaseImpl: KittyService): KittyGetter
}
