package vadc.heartbeatclient

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    private var notificationHelper: NotificationHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationHelper = NotificationHelper(this)
    }
}
