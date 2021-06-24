package com.example.navigationdrawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val items = mutableListOf<ItemMenu>()

    private lateinit var adapter: MenuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        setData()


        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setData(){
        items.add(ItemMenu(R.drawable.ic_home, "Home"))
        items.add(ItemMenu(R.drawable.ic_user, "Profile"))
        items.add(ItemMenu(R.drawable.ic_notifications, "Notification"))
        items.add(ItemMenu(R.drawable.ic_settings, "Setting"))
        items.add(ItemMenu(R.drawable.ic_home, "Home"))
        items.add(ItemMenu(R.drawable.ic_user, "Profile"))
        items.add(ItemMenu(R.drawable.ic_notifications, "Notification"))
        items.add(ItemMenu(R.drawable.ic_settings, "Setting"))



        adapter = MenuAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.itemMenuOnClick = {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        binding.recyclerView.adapter = adapter
    }


}