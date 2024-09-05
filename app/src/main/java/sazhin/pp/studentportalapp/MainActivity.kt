package sazhin.pp.studentportalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sazhin.pp.studentportalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
    }
}