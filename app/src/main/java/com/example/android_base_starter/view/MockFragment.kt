package com.example.android_base_starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.android_base_starter.databinding.FragmentMockBinding
import com.example.android_base_starter.view.adapter.ItemAdapter
import com.example.android_base_starter.viewModel.MainViewModel

class MockFragment : Fragment() {
    private lateinit var vb: FragmentMockBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentMockBinding.inflate(layoutInflater)
        viewModel.getItems()
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.items.observe(viewLifecycleOwner) { items ->
            vb.rvItems.adapter = ItemAdapter(items)
        }
    }
}