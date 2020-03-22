package app.pete.com.coroutinesample

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch


class MainActivityViewModel() : ViewModel(), LifecycleObserver {



    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        val api  = Api()
        //main threadで実行する
        Log.d("MainActivityViewModel","onResumeStart")
        viewModelScope.launch {
            try {
                api.isHoge().await().let {
                    Log.d("MainActivityViewModel", it.toString())
                }
            }catch (e: Throwable){
                Log.d("MainActivityViewModel", e.message)
            }
        }
        Log.d("MainActivityViewModel","onResumeEnd")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        //job cancel は不要
    }
}