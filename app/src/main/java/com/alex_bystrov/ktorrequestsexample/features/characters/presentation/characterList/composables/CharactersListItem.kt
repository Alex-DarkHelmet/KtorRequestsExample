package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.alex_bystrov.ktorrequestsexample.R
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterModel

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    model: CharacterModel,
    onCharacterClick: (CharacterModel) -> Unit
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF092034))
            .clickable { onCharacterClick(model) }
    ) {
        Row(
            modifier = modifier
        ) {
            AsyncImage(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                ,
                model = model.imageUrl,
                contentDescription = ""
            )

            Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                Text(
                    fontSize = 24.sp,
                    text = model.name
                )

                Row(
                    modifier = modifier.padding(4.dp)
                ) {
                    Image(
                        painter = if (model.status == "Alive") {
                        painterResource(id = R.drawable.baseline_circle_green_24)
                    } else {
                        painterResource(id = R.drawable.baseline_circle_red_24)
                    }, contentDescription = "")
                    
                    Spacer(modifier = modifier.width(4.dp))

                    Text(text = "${model.status} - ${model.gender}")
                }
            }
        }
    }
}