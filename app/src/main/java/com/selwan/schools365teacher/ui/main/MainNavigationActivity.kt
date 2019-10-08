package com.selwan.schools365teacher.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.core.view.GravityCompat
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.event.add_new.AddEventFragment
import com.selwan.schools365teacher.ui.event.main.EventMainFragment
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.homework.add_new.add_new_main.HomeworkAddNewMainFragment
import kotlinx.android.synthetic.main.activity_main_navigation.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.menu_filter

class MainNavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val menu: ImageView = findViewById(R.id.menu_toolbar)

        menu_filter.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if(menu_filter.isOpened){
                    menu_filter.close(true)
                }
                return true
            }

        })


        supportFragmentManager.beginTransaction()
            .replace(R.id.main_new_fragment, MainFragment())
            .commitAllowingStateLoss()

        add_exam.setOnClickListener {
            supportFragmentManager
                .beginTransaction().replace(R.id.main_new_fragment, ExaminationMainFragment())
                .commitAllowingStateLoss()
            menu_filter.hideMenu(true)
        }

        add_event.setOnClickListener {
            supportFragmentManager
                .beginTransaction().replace(R.id.main_new_fragment, EventMainFragment())
                .commitAllowingStateLoss()
            menu_filter.hideMenu(true)
        }
        add_homework.setOnClickListener {
            supportFragmentManager
                .beginTransaction().replace(R.id.main_new_fragment, HomeworkAddNewMainFragment())
                .commitAllowingStateLoss()

            menu_filter.hideMenu(true)

        }





        menu.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(
                GravityCompat.START
            )
            else drawerLayout.closeDrawer(GravityCompat.END)
        }



        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainNavigationActivity::class.java))

                }

                R.id.nav_setting -> {

                }
                R.id.nav_logout-> {

                }

            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }


}
