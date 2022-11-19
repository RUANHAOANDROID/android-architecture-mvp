package com.hao.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hao.mvp.counter.CounterFragment

/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *@see CounterFragment
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.content, CounterFragment())
            .commit()
    }
}