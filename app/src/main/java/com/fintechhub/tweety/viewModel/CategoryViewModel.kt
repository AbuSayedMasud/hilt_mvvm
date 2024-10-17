package com.fintechhub.tweety.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintechhub.tweety.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {
    val categories: StateFlow<List<String>>
        get() = repository.category

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}