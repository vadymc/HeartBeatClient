package vadc.heartbeatclient

import android.app.Activity
import android.os.Bundle
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : Activity() {

    private var notificationHelper: NotificationHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationHelper = NotificationHelper(this)
        MainUi(findViewById(R.id.activity_main), notificationHelper!!)
        initEventListener()
    }

    fun initEventListener() {
        FirebaseMessaging.getInstance().subscribeToTopic("notification_events")
            .addOnCompleteListener { task ->
                notificationHelper?.notify("Title", task.toString())
            }
    }
}
