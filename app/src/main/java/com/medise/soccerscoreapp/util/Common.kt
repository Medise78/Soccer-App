package com.medise.soccerscoreapp.util

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreData

fun Fragment.toast(message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.INVISIBLE
}

var lastMatch:LiveScoreData = LiveScoreData(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,)