package harrycoder.github.com.weebjournal.di

import dagger.multibindings.IntoMap
import dagger.Binds
import androidx.lifecycle.ViewModel
import dagger.Module
import harrycoder.github.com.weebjournal.ui.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

}