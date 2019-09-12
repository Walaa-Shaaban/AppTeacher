package com.selwan.schools365teacher.ui.communication.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class CommunicationNoticBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communication)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_communication, CommunicationNoticBoardFragment())
            .commitAllowingStateLoss()

    }
}
