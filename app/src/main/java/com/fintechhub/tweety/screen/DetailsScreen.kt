package com.fintechhub.tweety.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fintechhub.tweety.viewModel.CategoryViewModel
import com.fintechhub.tweety.viewModel.DetailsView

@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsView = hiltViewModel()
    val details = detailsViewModel.details.collectAsState()

    LazyColumn(
        content = {
            items(details.value) {
                TweetyItem(tweety = it.text)
            }
        }
    )
}

@Composable
fun TweetyItem(tweety: String) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xfffccccc)),
        content = {
            Text(
                text = tweety,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )

}