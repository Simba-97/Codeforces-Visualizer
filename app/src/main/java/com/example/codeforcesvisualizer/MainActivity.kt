package com.example.codeforcesvisualizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.codeforcesvisualizer.fragments.HomeFragment
import com.example.codeforcesvisualizer.fragments.SearchFragment
import com.example.codeforcesvisualizer.fragments.ShareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchFragment = SearchFragment()
        val homeFragment = HomeFragment()
        val shareFragment = ShareFragment()

        setCurrentFragment(homeFragment)

        btmNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miSearch -> setCurrentFragment(searchFragment)
                R.id.miShare -> setCurrentFragment(shareFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}