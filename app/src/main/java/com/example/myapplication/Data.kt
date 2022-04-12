package com.example.myapplication

/**
 * シェアードインスタンス
 * データ格納場所
 */
class Data {
    //シングルトンクラス 複数インスタンスを生成しても同じ値が返るもの
    companion object{ //Javaのstaticメソッドと同様の振る舞い ?
        var s_data:Data?=null
        fun getInstance():Data?
        {
            if(s_data==null){
                s_data = Data()
            }
            return s_data
        }
    }
    var cb1_checked = true
    var cb2_checked = false

}