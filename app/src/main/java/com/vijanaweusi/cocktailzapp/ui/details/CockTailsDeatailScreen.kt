package com.vijanaweusi.cocktailzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.vijanaweusi.model.response.CockTailsCategoryResponse

@Composable
fun CockTailDetailsScreen(cockTail: CockTailsCategoryResponse.CockTailsResponse?) {

    var profilePictureState by remember { mutableStateOf(CockTailProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val widthSize by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

    Column {

        Row {

            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = widthSize,
                    color = color
                )
            ) {
                Image(
                    painter = rememberImagePainter(data = cockTail?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }

            Text(
                text = cockTail?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        Button(modifier = Modifier
            .padding(16.dp),
            onClick = {
                profilePictureState = if (profilePictureState == CockTailProfilePictureState.Normal)
                    CockTailProfilePictureState.Expanded
                else
                    CockTailProfilePictureState.Normal
            }) {

            Text("Change state of meal profile picture")

        }

    }

}

enum class CockTailProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Red, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}

