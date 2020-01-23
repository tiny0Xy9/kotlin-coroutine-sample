package app.pete.com.coroutinesample

import kotlinx.coroutines.*

class Api(){
     suspend fun getHogeItems (): Deferred<Boolean> = coroutineScope {
            async (context = Dispatchers.IO) {
                true
            }
     }



}