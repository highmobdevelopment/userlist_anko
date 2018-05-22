package erevacation.com.userlistanko.injection.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

@Module
class NetModule {

    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}