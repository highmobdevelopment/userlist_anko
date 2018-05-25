package erevacation.com.userlistanko.homescreen.profile

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProfileFragmentModule {
    @Provides
    internal fun provideRequestPresenter(presenter: ProfileFragmentPresenter): ProfileContract.ProfilePresenter {
        return presenter
    }

    @Provides
    @Named("fragmentContext")
    fun provideFragmentContext(profileFragment: ProfileFragment): Context? {
        return profileFragment.context
    }
}