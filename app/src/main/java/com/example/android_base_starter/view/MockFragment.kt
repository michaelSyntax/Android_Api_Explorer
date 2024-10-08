package com.example.android_base_starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.android_base_starter.databinding.FragmentMockBinding
import com.example.android_base_starter.view.adapter.RestaurantAdapter
import com.example.android_base_starter.viewModel.MockViewModel

class MockFragment : Fragment() {
    private lateinit var vb: FragmentMockBinding
    private val viewModel: MockViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentMockBinding.inflate(layoutInflater)
        viewModel.getRestaurants()
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.restaurants.observe(viewLifecycleOwner) { restaurants ->
            vb.rvItems.adapter = RestaurantAdapter(restaurants)
        }
    }
}