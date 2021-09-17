package com.vijanaweusi.cocktailzapp.ui.cocktails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.vijanaweusi.cocktailzapp.ui.theme.CockTailzAppTheme
import com.vijanaweusi.model.response.CockTailsCategoryResponse

@ExperimentalCoilApi
@Composable
fun CockTailsCategoriesScreen () {
    val viewModel: CockTailsCategoriesViewModel = viewModel()
    val cockTails = viewModel.cockTailsState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {

        items(cockTails) { cockTail ->
            CockTailsCategory(cockTail)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CockTailsCategory(cockTail: CockTailsCategoryResponse.CockTailsResponse) {


    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {

            // Image
            Image(
                painter = rememberImagePainter(data = cockTail.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )


            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = cockTail.name,
                    style = MaterialTheme.typography.h6
                )

            }
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CockTailzAppTheme {
        CockTailsCategoriesScreen()

    }
}

