package com.medise.soccerscoreapp.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.medise.soccerscoreapp.MainActivity
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreData
import com.medise.soccerscoreapp.ui.match_detail.MatchDetailFragmentArgs
import com.medise.soccerscoreapp.util.lastMatch
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class ServiceApp: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @Inject
    lateinit var repository: SoccerRepository

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSelf()
    }
}