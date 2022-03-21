package com.example.didemo.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.didemo.MyApp
import com.example.didemo.databinding.FragmentDogImageBinding
import javax.inject.Inject

class DogImageFragment : Fragment() {

    private var _binding: FragmentDogImageBinding? = null
    private val binding: FragmentDogImageBinding
        get() = checkNotNull(_binding)

    @Inject
    lateinit var factory: DogImageViewModel.Factory
    private lateinit var viewModel: DogImageViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDogImageBinding.inflate(inflater).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        observeViwModel()
        setClickListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, factory)[DogImageViewModel::class.java]
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
