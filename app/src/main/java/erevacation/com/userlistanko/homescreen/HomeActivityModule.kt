package erevacation.com.userlistanko.homescreen

import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {
    @Provides
    internal fun provideHomePresenter(): HomeContract.HomePresenter {
        return HomeActivityPresenter()
    }
}