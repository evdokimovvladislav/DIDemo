package com.example.didemo.presentation

import androidx.lifecycle.*
import com.example.didemo.domain.usecases.GetDogUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View Model для получения картинки и статуса из Dog
 *
 * @property getDogUseCase use case получения собаки
 */
class DogImageViewModel(private val getDogUseCase: GetDogUseCase) : ViewModel() {

    /**
     * Url изображения собаки
     */
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    /**
     * Статус отправки
     */
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    init {
        updateDog()
    }

    /**
     * Скачать новые данные и обновить imageUrl и status
     */
    fun updateDog() {
        viewModelScope.launch {
            getDogUseCase().run {
                _imageUrl.value = message
                _status.value = status
            }
        }
    }

    /**
     * Фабрика для правильного создания DogImageViewModel
     *
     * @property getDogUseCase use case получения собаки
     */
    class Factory @Inject constructor(private val getDogUseCase: GetDogUseCase) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DogImageViewModel(getDogUseCase) as T
        }
    }
}