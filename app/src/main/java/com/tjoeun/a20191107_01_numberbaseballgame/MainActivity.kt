package com.tjoeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : BaseActivity() {

    var questionNumberArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion(){
        while (true) {
            val number = Random.nextInt(1, 9)
            if(!questionNumberArray.contains(number)){
                questionNumberArray.add(number)
            }

            if(questionNumberArray.size == 3) {
                break
            }
        }

        for(num in questionNumberArray){
            Log.d("로그",num.toString())
        }
    }

    override fun setValues() {

    }

    override fun setupEvents() {

    }
}
