package vadc.heartbeatclient

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color

class NotificationHelper(ctx: Context) : ContextWrapper(ctx) {

    private val channel = "default"

    private val manager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        val channel = NotificationChannel(
            channel,
            getString(R.string.default_notification_channel_name), NotificationManager.IMPORTANCE_HIGH
        )
        channel.lightColor = Color.GREEN
        channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        manager.createNotificationChannel(channel)
    }

    fun buildNotification(title: String, body: String): Notification {
        return Notification.Builder(applicationContext, channel)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setAutoCancel(true)
            .build()
    }

    fun notify(title: String, body: String) {
        manager.notify(1001, buildNotification(title, body))
    }
}