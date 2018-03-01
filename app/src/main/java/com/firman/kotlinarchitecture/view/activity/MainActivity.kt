package com.firman.kotlinarchitecture.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firman.kotlinarchitecture.R
import com.firman.kotlinarchitecture.view.fragment.UserListFragment

/**
 * Created by firman on 01/03/18.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_container, UserListFragment()).commit()
        }
    }
}
