package ar.edu.unlam.mobile.scaffold.data.di.kitty

import ar.edu.unlam.mobile.scaffold.data.network.kitty.KittyHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.network.kitty.KittyNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.repository.kitty.KittyDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.repository.kitty.KittyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KittyDataModule {
    @Binds
    abstract fun bindKittyRepository(kittyRepositoryImpl: KittyDefaultRepository): KittyRepository

    @Binds
    abstract fun bindKittyNetworkRepo(kittyHTTPClient: KittyHTTPRepository): KittyNetworkRepository
}
