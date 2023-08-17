package com.example.bottom_navigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_main)
        LoadFragment(homeFragment())
        val buttonNav=findViewById<BottomNavigationView>(R.id.bottomNav)
        buttonNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->LoadFragment(homeFragment())
                R.id.status->LoadFragment(StatusFragment())
                R.id.call->LoadFragment(CallFragment())
            }
            true
        }
    }


    private fun LoadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment).commit()
    }

}