package com.example.didemo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.didemo.MyApp
import com.example.didemo.data.RepositoryImpl
import com.example.didemo.databinding.ActivityMainBinding
import com.example.didemo.domain.repository.Repository
import com.example.didemo.domain.usecases.GetDogUseCase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            openFragment(binding.fragmentContainer.id, DogImageFragment())
        }
    }

    private fun openFragment(resId: Int, classFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(resId, classFragment)
            commit()
        }
    }
}