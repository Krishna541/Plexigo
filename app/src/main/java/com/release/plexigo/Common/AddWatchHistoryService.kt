package com.release.plexigo.Common

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.models.AddWatchHistoryRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class AddWatchHistoryService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    var TAG = this@AddWatchHistoryService.javaClass.simpleName + "fatal"
    override fun onCreate() {
        super.onCreate()

        // do stuff like register for BroadcastReceiver, etc.

        // Create the Foreground Service
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createNotificationChannel(
                notificationManager
            ) else ""
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
        val notification: Notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_MIN)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .build()
        startForeground(101, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager): String {
        val channelId = "my_service_channelid"
        val channelName = "My Foreground Service"
        val channel =
            NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        // omitted the LED color
        channel.importance = NotificationManager.IMPORTANCE_NONE
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notificationManager.createNotificationChannel(channel)
        return channelId
    }

    override fun onStartCommand(data: Intent, flags: Int, startId: Int): Int {
        try {
            if (data != null && data.hasExtra("playback")) {
                val startPosition = data.getIntExtra("playback", 0)
                val contentId = data.getIntExtra("contentId", 0)
                val POLLING_STOP = "0"
                Log.e(TAG, "startPosition $startPosition")
                Log.e(TAG, "contentId $contentId")
                addWatchHistory(startPosition, contentId, POLLING_STOP)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return START_STICKY
    }

    fun addWatchHistory(duration: Int, contentId: Int, POLLING_STOP: String?){
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = AddWatchHistoryRequest( Integer.valueOf(AppConstants.UserId),contentId,duration,POLLING_STOP!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addWatchHistory(request)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            stopSelf()
                        }else{
                            Toast.makeText(
                                this@AddWatchHistoryService,
                                "" + response.body()?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                            stopSelf()
                        }
                    }

                } catch (e: HttpException) {
                    Toast.makeText(this@AddWatchHistoryService, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                    stopSelf()
                } catch (e: Throwable) {
                    Toast.makeText(this@AddWatchHistoryService, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                    stopSelf()
                }
            }
        }
    }

}
