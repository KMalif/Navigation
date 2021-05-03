package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.fragment.CallFragment
import com.example.navigation.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup toggle menu
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Chat ->Toast.makeText(this, "You Click Chat item",Toast.LENGTH_SHORT).show()
                R.id.Call ->Toast.makeText(this, "You Click Call item",Toast.LENGTH_SHORT).show()
                R.id.Message ->Toast.makeText(this, "You Click Message item",Toast.LENGTH_SHORT).show()
                R.id.Reject ->Toast.makeText(this, "You Click Rejected call item",Toast.LENGTH_SHORT).show()
                R.id.Acount ->Toast.makeText(this, "You Click Acount item",Toast.LENGTH_SHORT).show()
                R.id.Logout ->Toast.makeText(this, "You Click Logout item",Toast.LENGTH_SHORT).show()
            }
            true
        }

        setCurrentFragment(CallFragment())
        binding.BottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.mi_call -> setCurrentFragment(CallFragment())
                R.id.mii_search ->setCurrentFragment(SearchFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.Container, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}