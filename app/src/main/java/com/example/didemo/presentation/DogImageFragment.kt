package com.example.didemo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.didemo.databinding.FragmentDogImageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DogImageFragment : Fragment() {

    private var _binding: FragmentDogImageBinding? = null
    private val binding: FragmentDogImageBinding
        get() = checkNotNull(_binding)

    private val viewModel by viewModel<DogImageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDogImageBinding.inflate(inflater).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViwModel()
        setClickListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun observeViwModel() {
        viewModel.imageUrl.observe(viewLifecycleOwner) { url ->
            Glide.with(this).load(url).into(binding.image)
        }

        viewModel.status.observe(viewLifecycleOwner) {
            binding.statusText.text = it
        }
    }

    private fun setClickListeners() {
        binding.getButton.setOnClickListener {
            viewModel.updateDog()
        }
    }
}