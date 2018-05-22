package erevacation.com.userlistanko.injection.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlistanko.homescreen.HomeActivity
import erevacation.com.userlistanko.homescreen.HomeActivityModule
import erevacation.com.userlistanko.injection.provider.FragmentProvider

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    internal abstract fun bindHomeActivity(): HomeActivity

}