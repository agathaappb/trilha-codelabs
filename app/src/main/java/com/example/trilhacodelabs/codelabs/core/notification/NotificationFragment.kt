package com.example.trilhacodelabs.codelabs.core.notification

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.trilhacodelabs.R
import com.example.trilhacodelabs.databinding.FragmentNotificationBinding

/*Material de estudo:
    -> https://www.youtube.com/watch?v=iDlRsZ-hAU8&list=PLCUEGRQ1UHfLLN7MDe4mX4RkbC685RGOC&index=3&ab_channel=ProgramadordeElite
*/
class NotificationFragment : Fragment(R.layout.fragment_notification) {
   private lateinit var binding: FragmentNotificationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNotificationBinding.bind(view)

        setNavBar(binding)

    }

    private fun setNavBar(binding: FragmentNotificationBinding){
        (activity as AppCompatActivity).setSupportActionBar(binding.navbarNotification.toobar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.navbarNotification.toobar.setupWithNavController(navController,appBarConfiguration)
        binding.navbarNotification.toobar.setTitle(R.string.title_notification)
    }
}