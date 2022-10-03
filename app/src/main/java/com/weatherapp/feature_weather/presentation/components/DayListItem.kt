package com.weatherapp.feature_weather.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime

@Composable
fun DayListItem(
    dateTime: LocalDateTime,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .width(86.dp)
            .selectable(
                selected = true,
                onClick = { onItemClick() }
            ),
        backgroundColor = if(isSelected)
            MaterialTheme.colors.secondary else MaterialTheme.colors.background,
        elevation = 10.dp
//        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "${dateTime.dayOfWeek.name}\n${dateTime.month.name}\n${dateTime.dayOfMonth}",
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 20.sp,
        )
    }
}