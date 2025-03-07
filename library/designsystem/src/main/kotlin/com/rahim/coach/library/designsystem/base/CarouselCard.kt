package com.rahim.coach.library.designsystem.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen
import com.rahim.coach.library.designsystem.theme.MediumAquamarine
import com.rahim.coach.library.designsystem.theme.OuterSpace
import com.rahim.coach.library.designsystem.theme.font_bold
import com.rahim.coach.library.designsystem.theme.font_standard

@Composable
fun CarouselCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    duration: String,
    onAddClick: () -> Unit,
    onCardClick: () -> Unit,
) {

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

    Card(
        modifier = modifier
            .size(
                width = 160.dp,
                height = 250.dp
            )
            .clickable { onCardClick() },
        shape = RoundedCornerShape(size.extraSmall),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = size.default)
    ) {
        Column {
            // Image Section
            Image(
                painter = painterResource(R.drawable.food),
                contentDescription = "Card Image",
                modifier = Modifier
                    .padding(space.default)
                    .clip(RoundedCornerShape(size.extraSmall))
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(space.medium))

            // Text Section
            Column(
                modifier = Modifier
                    .padding(horizontal = space.small)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = font_bold,
                        fontWeight = FontWeight.Bold,
                        fontSize = fontSize.default,
                        color = OuterSpace
                    )
                )
                Spacer(modifier = Modifier.height(space.default))
                Text(
                    text = description,
                    style = TextStyle(
                        fontFamily = font_standard,
                        fontWeight = FontWeight.Normal,
                        fontSize = fontSize.extraExtraSmall,
                        color = OuterSpace
                    )
                )
            }

            Spacer(modifier = Modifier.height(space.small))

            // Bottom Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space.extraSmall),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Duration Icon and Text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Duration Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(size.small)
                    )

                    Spacer(modifier = Modifier.width(space.default))

                    Text(
                        text = duration,
                        style = TextStyle(
                            fontFamily = font_standard,
                            fontWeight = FontWeight.Normal,
                            fontSize = fontSize.extraExtraSmall,
                            color = OuterSpace
                        )
                    )
                }

                // Add Button
                Box(
                    modifier = Modifier
                        .size(size.large)
                        .background(
                            color = MediumAquamarine,
                            shape = RoundedCornerShape(size.extraSmall)
                        )
                        .padding(space.default)
                        .clickable { onAddClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_add_24),
                        contentDescription = "Add Icon",
                        tint = CaribbeanGreen,
                        modifier = Modifier.size(size.extraSmall)
                    )
                }
            }

            Spacer(modifier = Modifier.height(space.extraSmall))
        }
    }
}