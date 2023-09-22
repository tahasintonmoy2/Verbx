package com.android.verbx

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.android.verbx.databinding.ActivityMainBinding
import com.android.verbx.fragments.BottomSheetFragment
import com.android.verbx.fragments.CartFragment
import com.android.verbx.fragments.HomeFragment
import com.android.verbx.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)
        setSupportActionBar(binding.searchBar)
        replaceFragment(HomeFragment())

        //setupWithNavController(navController, bottomNavigationView)

        binding.mdcBottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.homeFragment -> {
                    binding.searchBar.visibility = View.VISIBLE
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.cartFragment -> {
                    binding.searchBar.visibility = View.GONE
                    replaceFragment(CartFragment())
                    true
                }
                R.id.profileFragment -> {
                    binding.searchBar.visibility = View.GONE
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        binding.searchBar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.filter){
               val bottomSheetFragment = BottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }
            if (menuItem.itemId == R.id.searchBar_notifications){
                Toast.makeText(this, "Show NTS", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_content_main, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}