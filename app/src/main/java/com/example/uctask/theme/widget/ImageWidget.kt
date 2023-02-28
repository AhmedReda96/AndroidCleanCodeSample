package com.example.uctask.theme.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerId
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.uctask.utils.getImageUrl

@Composable
fun ImageWidget(pointer:String,height:Dp) {
    Image(
        painter = rememberAsyncImagePainter(pointer),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentScale = ContentScale.FillBounds
    )
}
