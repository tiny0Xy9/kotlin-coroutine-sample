package app.pete.com.coroutinesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model =  ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)
        lifecycle.addObserver(model)
    }
}
