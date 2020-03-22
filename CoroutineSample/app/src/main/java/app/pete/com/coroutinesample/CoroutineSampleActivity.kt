package app.pete.com.coroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.util.Log
import kotlinx.coroutines.*


class CoroutineSampleActivity : AppCompatActivity() {

    val TAG = "CoroutineSampleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sample)

        //run bloaking

        Log.d(TAG,"1")
        runBlocking {
            Log.d(TAG,"2")
        }
        Log.d(TAG,"3")

        //launch
        Log.d(TAG,"4")
        GlobalScope.launch{
            Log.d(TAG,"5")
        }
        Log.d(TAG,"6")

        //launch join
        runBlocking {
            Log.d(TAG,"7")
            GlobalScope.launch {
                Log.d(TAG, "8")
            }.join()
            Log.d(TAG,"9")
        }

        //async & await
        runBlocking {
            Log.d(TAG,"10")
            async {
                Log.d(TAG, "11")
            }.await()
            Log.d(TAG,"12")
        }

        //call suspend function
        runBlocking {
            async {
                getProfile()
            }.await()
        }


    }

    suspend fun getProfile(){
           delay(1000)
           Log.d(TAG,"getProfile")
    }
}
