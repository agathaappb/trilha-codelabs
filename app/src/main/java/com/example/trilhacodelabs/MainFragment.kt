package com.example.trilhacodelabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.trilhacodelabs.databinding.FragmentMainBinding
class MainFragment : Fragment(R.layout.fragment_main){

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)
    }
}