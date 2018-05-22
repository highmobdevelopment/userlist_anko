package erevacation.com.userlistanko.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlistanko.homescreen.list.ListFragment
import erevacation.com.userlistanko.homescreen.list.ListFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment

}