package com.example.trilhacodelabs.codelabs.core.toast

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trilhacodelabs.R
import com.example.trilhacodelabs.databinding.FragmentToastSnakeBinding
import com.example.trilhacodelabs.util.navTo
import com.example.trilhacodelabs.util.toast
import com.google.android.material.snackbar.Snackbar

// Material de estudo:
// https://material.io/archive/guidelines/components/snackbars-toasts.html#snackbars-toasts-usage
//https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=pt-br
//https://m2.material.io/components/snackbars

class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentToastSnakeBinding.bind(view)

        setNavBar(binding)

        //definindo orientação da fragment
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding.btnToast.setOnClickListener { toast("Sou um Toast") }

        binding.btnSnake.setOnClickListener {
            Snackbar.make(view,"Sou um Snake",Snackbar.LENGTH_SHORT).show()
        }

        binding.btnSnakeAction.setOnClickListener {
            Snackbar.make(view,"Sou um Snake com ação", Snackbar.LENGTH_SHORT)
                .setAction("Ok"){toast("Bye!! :D")}
                .show()
        }
    }

    private fun setNavBar(binding: FragmentToastSnakeBinding){
        (activity as AppCompatActivity).setSupportActionBar(binding.navbarToastSnake.toobar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.navbarToastSnake.toobar.setupWithNavController(navController,appBarConfiguration)
        binding.navbarToastSnake.toobar.setTitle("Toast e Snake")
    }

}