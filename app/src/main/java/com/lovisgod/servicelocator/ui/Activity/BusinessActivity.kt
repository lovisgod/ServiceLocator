package com.lovisgod.servicelocator.ui.Activity

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.lovisgod.servicelocator.R
import com.pixplicity.easyprefs.library.Prefs

class BusinessActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business)

        drawerLayout= findViewById(R.id.drawer_layout)
        appBarLayout = findViewById(R.id.tool_bar_layout)
        toolbar = findViewById(R.id.tool_bar)
        var navigationView: NavigationView = findViewById(R.id.business_nav_view)
        var hView = navigationView.getHeaderView(0)
        navigationView.itemIconTintList = null
        navController = Navigation.findNavController(this, R.id.app_nav_host_fragment)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
        NavigationUI.setupWithNavController(toolbar, navController)
        val colorDrawable = ColorDrawable(Color.parseColor("#44E6C6"))

        // Set BackgroundDrawable

        // Set BackgroundDrawable
        appBarLayout.setBackgroundDrawable(colorDrawable)

        var menuIcon = findViewById<ImageView>(R.id.menu_icon)
        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        var logout = findViewById<TextView>(R.id.logout)
        logout.setOnClickListener {
            Prefs.putString("token", "")
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id != R.id.landingFragment ){
                appBarLayout.visibility = View.VISIBLE
                menuIcon.visibility = View.GONE
                toolbar.title = ""
            }

            if (destination.id  == R.id.landingFragment){
                appBarLayout.visibility = View.GONE
                menuIcon.visibility = View.VISIBLE
            }
        }

        /*
     *  handle navigation header clicked
     * */
        hView.setOnClickListener {
            Toast.makeText(this, "this is working", Toast.LENGTH_LONG).show()
            drawerLayout.closeDrawers()
//            navController.navigate(R.id.profileFragment)
        }
    }

    // handles navigation click listener

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawerLayout.closeDrawers()
        val id = item.itemId
        if (id == R.id.nav_profile) {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_LONG).show()
        }
        return true
    }
}
