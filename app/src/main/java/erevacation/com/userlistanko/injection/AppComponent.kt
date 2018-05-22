package erevacation.com.userlistanko.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import erevacation.com.userlistanko.MainActivity
import erevacation.com.userlistanko.injection.builders.ActivityBuilder
import erevacation.com.userlistanko.injection.modules.AppModule
import erevacation.com.userlistanko.injection.modules.NetModule


@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (NetModule::class), (ActivityBuilder::class)])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainActivity)
}
