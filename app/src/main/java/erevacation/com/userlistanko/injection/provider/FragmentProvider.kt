package erevacation.com.userlistanko.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlistanko.homescreen.list.ListFragment
import erevacation.com.userlistanko.homescreen.list.ListFragmentModule
import erevacation.com.userlistanko.homescreen.profile.ProfileFragment
import erevacation.com.userlistanko.homescreen.profile.ProfileFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment
    @ContributesAndroidInjector(modules = [(ProfileFragmentModule::class)])
    abstract fun provideProfileFragmentFactory(): ProfileFragment


}