package com.example.trilhacodelabs.codelabs.core.toast

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.res.stringResource
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

/* Material de estudo:
 -> https://material.io/archive/guidelines/components/snackbars-toasts.html#snackbars-toasts-usage
 -> https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=pt-br
 -> https://m2.material.io/components/snackbars
*/

class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentToastSnakeBinding.bind(view)

        setNavBar(binding)

        //definindo orientação da fragment
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding.btnToast.setOnClickListener { toast(requireActivity().getString(R.string.msg_toast)) }

        binding.btnSnake.setOnClickListener {
            Snackbar.make(view,R.string.msg_snake,Snackbar.LENGTH_SHORT).show()
        }

        binding.btnSnakeAction.setOnClickListener {
            Snackbar.make(view,R.string.msg_snake_action, Snackbar.LENGTH_SHORT)
                .setAction(R.string.btn_confirmation){toast(requireActivity().getString(R.string.msg_snake_action_closed))}
                .show()
        }
    }

    private fun setNavBar(binding: FragmentToastSnakeBinding){
        (activity as AppCompatActivity).setSupportActionBar(binding.navbarToastSnake.toobar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.navbarToastSnake.toobar.setupWithNavController(navController,appBarConfiguration)
        binding.navbarToastSnake.toobar.setTitle(R.string.title_toast_snake)

    }

}