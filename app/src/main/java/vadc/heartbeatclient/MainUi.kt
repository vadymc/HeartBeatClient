package vadc.heartbeatclient

import android.view.View
import android.widget.Button

class MainUi(root: View, notificationHelper: NotificationHelper) : View.OnClickListener {

    private var notificationHelper: NotificationHelper = notificationHelper

    init {
        root.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.send_btn -> notificationHelper.notify("Test title", "test body")
        }
    }
}