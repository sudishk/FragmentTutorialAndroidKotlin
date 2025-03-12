package com.edugaon.fragmenttutorial

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        val previousButton = findViewById<Button>(R.id.previousButton)
        var fragmentIndex = 0
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment()).commitNow()

        nextButton.setOnClickListener {
            if (fragmentIndex==0){
                fragmentIndex = 1
                val fragment = SecondFragment()
                val bundle = Bundle()
                bundle.putString("fragmentName_key", "SecondFragment")

                fragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commitNow()
            }
        }
        previousButton.setOnClickListener {
            if (fragmentIndex==1){
                fragmentIndex = 0
                val fragment = FirstFragment()
                val bundle = Bundle()
                bundle.putString("fragmentName_key", "FirstFragment")

                fragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commitNow()
            }
        }

    }

}