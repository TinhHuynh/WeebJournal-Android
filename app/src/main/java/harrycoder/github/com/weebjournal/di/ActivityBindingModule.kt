package harrycoder.github.com.weebjournal.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import harrycoder.github.com.weebjournal.ui.HomeActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity

}