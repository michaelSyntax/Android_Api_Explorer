package com.example.android_base_starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.android_base_starter.R
import com.example.android_base_starter.databinding.FragmentGoogleBinding
import com.example.android_base_starter.databinding.FragmentMockBinding
import com.example.android_base_starter.view.adapter.ItemAdapter
import com.example.android_base_starter.viewModel.MainViewModel

class GoogleFragment : Fragment() {
    private lateinit var vb: FragmentGoogleBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentGoogleBinding.inflate(layoutInflater)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}