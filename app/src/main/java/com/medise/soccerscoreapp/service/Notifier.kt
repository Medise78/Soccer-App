package com.medise.soccerscoreapp.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.medise.soccerscoreapp.MainActivity
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreData
import com.medise.soccerscoreapp.ui.match_detail.MatchDetailFragmentArgs

class Notifier(val context: Context) {


    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "ChannelName"
            val channelDescription = "description"
            val channelId = channelName
            val importance = NotificationManager.IMPORTANCE_LOW

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendNotification(liveScoreData: LiveScoreData?, enable: Boolean): Boolean {
        val notification = notification(liveScoreData!!)
        return if (enable) {
            with(NotificationManagerCompat.from(context)) {
                val notificationId = liveScoreData.id
                notify(notificationId!!, notification)
            }
            true
        } else {
            false
        }
    }

    fun notification(liveScoreData: LiveScoreData): Notification {
        val pendingIntent = NavDeepLinkBuilder(context)
            .setComponentName(MainActivity::class.java)
            .setGraph(R.navigation.app_navigation)
            .setDestination(R.id.matchDetailFragment)
            .setArguments(
                MatchDetailFragmentArgs(liveScoreData).toBundle()
            )
            .createPendingIntent()

        val bitmapLargeIcon = BitmapFactory.decodeResource(context.resources, R.drawable.ic_ball)

        val builder = NotificationCompat.Builder(context, "ChannelName")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("${liveScoreData.localTeam?.data?.name} VS ${liveScoreData.visitorTeam?.data?.name}")
            .setContentText("${liveScoreData.scoresDto?.localteamScore} - ${liveScoreData.scoresDto?.visitorteamScore}")
            .setLargeIcon(bitmapLargeIcon)
            .setContentIntent(
                pendingIntent
            )
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        return builder.build()
    }
}