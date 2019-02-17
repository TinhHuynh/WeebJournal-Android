package harrycoder.github.com.weebjournal.data.repository

import androidx.lifecycle.MutableLiveData
import harrycoder.github.com.weebjournal.data.model.Post
import harrycoder.github.com.weebjournal.data.network.WjApi

class PostRepository(tmdbApi: WjApi) {
    fun getPopularMovies(): MutableLiveData<List<Post>>? {
        return null;
    }

}
