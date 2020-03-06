package app.pete.com.coroutinesample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model =  ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)
        lifecycle.addObserver(model)
        //todo syntheticはライフサイクルで作り直された時になどに、nullになる可能性があるため、非推奨
        startcoroutine.setOnClickListener {
            startActivity(Intent(this,CoroutineSampleActivity::class.java))
        }


    }
}
