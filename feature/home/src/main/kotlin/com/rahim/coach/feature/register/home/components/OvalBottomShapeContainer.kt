package com.rahim.coach.feature.register.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp

@Composable
fun CustomOvalBottomShapeContainer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    ovalHeight: Float? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .drawBehind {
                drawPath(
                    path = createOvalBottomPath(ovalHeight ?: size.height),
                    color = backgroundColor
                )
            }
    ) {
        content()
    }
}


private fun DrawScope.createOvalBottomPath(
    ovalHeight: Float,
): Path {
    val constantOffsetPx = size.width / 6
    val path = Path()
    path.moveTo(0f, 0f) // Top-left corner
    path.lineTo(size.width, 0f) // Top-right corner
    path.lineTo(size.width, ovalHeight - constantOffsetPx) // Bottom-right corner (before oval)
    path.quadraticTo(
        x1 = size.width / 2,
        y1 = ovalHeight + constantOffsetPx,
        x2 = 0f,
        y2 = ovalHeight - constantOffsetPx
    ) // Oval bottom-left
    path.close()
    return path
}

//@Preview
//@Composable
//fun QuadraticPathDemo() {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        val controlPoint = Size(300f, 900f)
//        val endPoint = Size(500f, 600f)
//        val path = Path().apply {
//            // Start at (100, 600)
//            moveTo(100f, 600f)
//            // Create a quadratic Bézier curve with control point at (300, 200) and endpoint at (500, 600)
//            quadraticTo(controlPoint.width, controlPoint.height, endPoint.width, endPoint.height)
//        }
//
//        // Draw the path with a stroke
//        drawPath(
//            path = path,
//            color = Color.Blue,
//            style = Stroke(width = 5.dp.toPx())
//        )
//
//        // Draw control and endpoint markers for clarity
//        drawCircle(
//            color = Color.Red,
//            center = Offset(controlPoint.width, controlPoint.height),
//            radius = 10f
//        )
//        drawCircle(
//            color = Color.Green,
//            center = Offset(endPoint.width, endPoint.height),
//            radius = 10f
//        )
//    }
//}