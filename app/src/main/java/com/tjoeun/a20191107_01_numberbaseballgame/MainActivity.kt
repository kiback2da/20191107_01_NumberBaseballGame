package com.tjoeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191107_01_numberbaseballgame.adapter.ChatAdapter
import com.tjoeun.a20191107_01_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {

    var questionNumberArray = ArrayList<Int>()
    var userInputNumberArray = ArrayList<Int>()

    var chatList = ArrayList<ChatData>()
    var chatAdapter:ChatAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion(){
        while (true) {
            val number = Random.nextInt(1, 10)
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
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }

    fun checkAnswer(){

        for(i in 0..2){
            for(j in 0..2){

            }
        }
    }

    override fun setupEvents() {
        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()
            chatList.add(ChatData(inputNum,"ME"))
            chatAdapter?.notifyDataSetChanged()

            userInputNumberArray.clear()
            userInputNumberArray.add(inputNum.toInt()/100) //맨 앞 숫자 추출
            userInputNumberArray.add(inputNum.toInt()/10%10) //두번째 숫자 추출
            userInputNumberArray.add(inputNum.toInt()%10) //마지막 숫자 추출

            chatListView.smoothScrollToPosition(chatList.size-1)
            checkAnswer()
        }
    }
}
