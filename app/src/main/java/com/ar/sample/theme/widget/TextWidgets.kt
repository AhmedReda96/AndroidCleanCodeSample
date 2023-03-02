package com.ar.sample.theme.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalText(query: String) {
    Text(
        text = query,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}
