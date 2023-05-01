package com.example.trilhacodelabs.codelabs.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.trilhacodelabs.R
import com.example.trilhacodelabs.databinding.FragmentNotificationBinding

/*Material de estudo:
    -> https://www.youtube.com/watch?v=iDlRsZ-hAU8&list=PLCUEGRQ1UHfLLN7MDe4mX4RkbC685RGOC&index=3&ab_channel=ProgramadordeElite
    -> https://developer.android.com/training/notify-user/build-notification?hl=pt-br
    -> https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=pt-br
    -> https://m2.material.io/design/platform-guidance/android-notifications.html#usage
*/

private const val NOTIFICATION_ID = 0
private const val PRIMARY_CHANNEL_ID = "primary_notification_channel"
private const val ACTION_UPDATE = "ACTION_UPDATE_NOTIFICATION"
private const val ACTION_CANCEL = "ACTION_CANCEL_NOTIFICATION"
private const val ACTION_DELETE_ALL = "ACTION_DELETED_NOTIFICATIONS"

class NotificationFragment : Fragment(R.layout.fragment_notification) {

   private lateinit var binding: FragmentNotificationBinding
   private lateinit var notificationManager: NotificationManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNotificationBinding.bind(view)

        setNavBar(binding)
        setupUiButtonsListeners()
        setupUiButtonStates(true,false,false)
        createChannelNotification()

    }

    private fun setNavBar(binding: FragmentNotificationBinding){
        (activity as AppCompatActivity).setSupportActionBar(binding.navbarNotification.toobar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.navbarNotification.toobar.setupWithNavController(navController,appBarConfiguration)
        binding.navbarNotification.toobar.setTitle(R.string.title_notification)
    }

    private fun setupUiButtonsListeners(){
        binding.btnSendNotification.setOnClickListener { sendNotification() }
        binding.btnUpdateNotification.setOnClickListener { updateNotification() }
        binding.btnCancelNotification.setOnClickListener { cancelNotification() }
    }

    private fun setupUiButtonStates(
        enableBotify:Boolean,
        enableUpdate:Boolean,
        enabledCancel:Boolean
    ){
        binding.btnSendNotification.isEnabled = enableBotify
        binding.btnUpdateNotification.isEnabled = enableUpdate
        binding.btnCancelNotification.isEnabled = enabledCancel
    }

    private fun sendNotification(){
        val builder = NotificationCompat.Builder(requireActivity(), PRIMARY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_bee_flower)
            .setContentTitle("Teste Notification")
            .setContentText("Este é um teste de notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(NOTIFICATION_ID,builder.build())

        setupUiButtonStates(false,true,true)
    }

    private fun createChannelNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nameChannel = "channel_notification_codelabs"
            val descriptionChannel = "this is my new channel for notifications in project codelabs"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(PRIMARY_CHANNEL_ID, nameChannel, importance).apply {
                description = descriptionChannel
            }

            notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }

    private fun cancelNotification(){
        notificationManager.cancel(NOTIFICATION_ID)
        setupUiButtonStates(true,false, false)
    }

    private fun updateNotification(){
        val image = BitmapFactory.decodeResource(resources,R.drawable.ic_bee_flower)

        val notificationUpdate = NotificationCompat.Builder(requireActivity(), PRIMARY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_bee_flower)
            .setContentTitle("Teste Update Notification")
            .setContentText("Este é um teste de atualização de notification")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setColorized(true)

        notificationManager.notify(NOTIFICATION_ID,notificationUpdate.build())
        setupUiButtonStates(false,false,true)
    }

}