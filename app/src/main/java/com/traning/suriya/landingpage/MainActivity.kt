package com.traning.suriya.landingpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.traning.suriya.landingpage.landing.LandingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(container.id, LandingFragment.newInstance())
                .commitNow()
        }
    }
}
