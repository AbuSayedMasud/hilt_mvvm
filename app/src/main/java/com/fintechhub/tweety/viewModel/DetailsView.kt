package com.fintechhub.tweety.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintechhub.tweety.model.TweetyDataItem
import com.fintechhub.tweety.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsView @Inject constructor(
    private val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val details: StateFlow<List<TweetyDataItem>>
        get() = repository.tweety

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("message") ?: "technology"
            repository.getTweets(category)
        }
    }
}