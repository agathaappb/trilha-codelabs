package com.example.trilhacodelabs.codelabs.core.toast

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.trilhacodelabs.R
import com.example.trilhacodelabs.databinding.FragmentToastSnakeBinding
import com.example.trilhacodelabs.util.toast
import com.google.android.material.snackbar.Snackbar

class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentToastSnakeBinding.bind(view)

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


}