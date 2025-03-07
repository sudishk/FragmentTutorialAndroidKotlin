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
        val prevButton = findViewById<Button>(R.id.prevButton)
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragmentContainer)
        var count = 0
        changeFragment(FirstFragment())
        nextButton.setOnClickListener {

            if (count==0){
                count++
                changeFragment(SecondFragment())
                // second fragment
            }else if (count==1){
                count++
                changeFragment(ThirdFragment())

                // third fragment
            }else {
                count=0
                changeFragment(FirstFragment())
                // first fragment
            }
        }

        prevButton.setOnClickListener {

            if (count==0){
                count = 2
                changeFragment(ThirdFragment())
                // third fragment
            }else if (count==2){
                count--
                changeFragment(SecondFragment())

                // second fragment
            }else {
                count=0
                changeFragment(FirstFragment())
                // first fragment
            }
        }

    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commitNow()
    }


}