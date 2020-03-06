package app.pete.com.coroutinesample

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel() : ViewModel(), CoroutineScope, LifecycleObserver {


    private val job = Job()

    // このスコープのコンテキストを提供する。
    // Dispatcher.Main を指定しているためこのスコープで起動するコルーチンはメインスレッドで動作する。
    // Job として上で定義した job を渡しているので、すべてのコルーチンはこの job の子になる。
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val scope = CoroutineScope(coroutineContext)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        val api  = Api()
        //main threadで実行する
        Log.d("MainActivityViewModel","onResumeStart")
        scope.launch {
            try {
                api.getHogeItems().await().let {
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
        //jobに属している全てのtaskを停止する
        job.cancel()
    }


}