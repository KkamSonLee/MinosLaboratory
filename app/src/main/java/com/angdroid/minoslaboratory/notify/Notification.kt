package com.angdroid.minoslaboratory.notify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import coil.Coil
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.presentation.main.component.MainMviActivity
import com.angdroid.minoslaboratory.presentation.util.toMillis
import java.time.LocalDateTime
import kotlin.random.Random


class Notification(
    private val context: Context,
    private val title: String,
    private val body: String
) {
    init {
        val builder = setBuilder()

        try {
            asyncLoadIcon("https://is4-ssl.mzstatic.com/image/thumb/Music112/v4/b8/49/62/b849627f-23c6-1bfb-e682-2492c89c549e/8809900755124.jpg/400x400bb.jpg") { icon ->
                val user: Person = Person.Builder().setIcon(icon).setName("이민호").build()
                Log.e("CALLBACK", icon.toString())
                val style = NotificationCompat.MessagingStyle(user).addMessage(title, LocalDateTime.now().toMillis()!!, user)
                builder.setSmallIcon(R.drawable.ic_launcher_foreground)
                builder.setStyle(style)
                createNotificationChannel().notify(Random.nextInt(), builder.build())
            }

        } catch (e: Exception) {
            Log.e("LMH", "ERROR $e")
        }
    }

    private fun setBuilder(): NotificationCompat.Builder {
        val resultPendingIntent = setPendingIntent()

        return with(context) {
            NotificationCompat.Builder(this, "notify")
                .setContentText(body)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(resultPendingIntent)
                .setFullScreenIntent(resultPendingIntent, true)
        }
    }

    private fun setPendingIntent(): PendingIntent {
        val resultIntent = Intent(context, MainMviActivity::class.java)
        return TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(resultIntent)
            getPendingIntent(
                1,
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT else PendingIntent.FLAG_UPDATE_CURRENT
            )
        }
    }

    private fun createNotificationChannel(): NotificationManager {
        val name = "notify"
        val descriptionText = "Description"
        val importance = NotificationManager.IMPORTANCE_MAX
        val channel = NotificationChannel(
            "notify",
            name,
            importance
        ).apply {
            description = descriptionText
            setShowBadge(true)
            enableVibration(true)
            enableLights(true)
            lockscreenVisibility = android.app.Notification.VISIBILITY_PUBLIC
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        return notificationManager

    }

    private fun asyncLoadIcon(imageUrl: String, setIcon: (IconCompat) -> Unit) {
        if (imageUrl.isEmpty()) {
            Log.e("IS EMPTY", imageUrl)
            setIcon(IconCompat.createWithResource(context, R.drawable.ic_launcher_foreground))
        }
        else {
            Log.e("CALL", "coil $imageUrl")
            // using COIL to load the image
            val request = ImageRequest.Builder(context)
                .data(imageUrl)
                .target { drawable ->

                    Log.e("CALL", "Target")
                    setIcon(IconCompat.createWithBitmap((drawable as BitmapDrawable).bitmap)) //  // Return the fetched icon from the URL
                }
                .listener(object : ImageRequest.Listener { // Return null icon if the URL is wrong
                    override fun onError(request: ImageRequest, result: ErrorResult) {
                        Log.e("CALL", "onError ${result.throwable}")
                        setIcon(IconCompat.createWithResource(context, R.drawable.ic_launcher_foreground))
                    }

                    override fun onSuccess(request: ImageRequest, result: SuccessResult) {
                        super.onSuccess(request, result)
                        Log.e("CALL", "Success")
                    }
                })
                .build()
            Coil.imageLoader(context).enqueue(request)
        }
    }

}