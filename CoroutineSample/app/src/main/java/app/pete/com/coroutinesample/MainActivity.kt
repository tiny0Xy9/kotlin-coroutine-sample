package app.pete.com.coroutinesample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model =  ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)
        lifecycle.addObserver(model)

        startActivity(Intent(this,CoroutineSampleActivity::class.java))

    }
}
