package com.tjoeun.a20191107_01_numberbaseballgame.datas

import java.io.Serializable

class ChatData(message:String, speaker:String): Serializable {

    var dMessage = message
    var dSpeaker = speaker

}