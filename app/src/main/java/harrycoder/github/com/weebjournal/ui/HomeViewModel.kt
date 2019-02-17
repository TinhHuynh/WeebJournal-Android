package harrycoder.github.com.weebjournal.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import harrycoder.github.com.weebjournal.data.model.Post
import harrycoder.github.com.weebjournal.data.repository.PostRepository
import javax.inject.Inject


class HomeViewModel
@Inject constructor(application: Application, private val repository: PostRepository)
    : AndroidViewModel(application) {

    private var postsLiveData: MutableLiveData<List<Post>>? = null

    init {

        postsLiveData = repository.getPopularMovies()

    }

    fun getpostsLiveData() = postsLiveData

}