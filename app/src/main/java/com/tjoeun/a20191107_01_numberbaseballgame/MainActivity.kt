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

    override fun setupEvents() {
        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()
            chatList.add(ChatData(inputNum,"ME"))
            chatAdapter?.notifyDataSetChanged()
            chatListView.smoothScrollToPosition(chatList.size-1)
        }
    }
}
