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

@Composable
fun CustomOvalBottomShapeContainer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    x1: Float, y1: Float, x2: Float, y2: Float,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .drawBehind {
                drawPath(
                    path = createOvalBottomPath(x1,y1,x2,y2),
                    color = backgroundColor
                )
            }
    ) {
        content()
    }
}


/**
 * Creates a Path that forms a shape with a straight top and an oval at the bottom.
 *
 * This function constructs a closed Path that starts from the top-left corner,
 * moves to the top-right corner, then down to a point on the right edge where the oval starts.
 * It then uses a quadratic curve to create the oval's bottom shape and connects back to the
 * starting point on the left, forming a closed shape.
 *
 * The oval portion is created using a quadratic Bezier curve. The control point [x1, y1]
 * determines the shape of the curve. The end point of the quadratic curve is described by [x2, y2]
 * The curve extends from the right side of the shape to the left.
 *
 * The height of the oval is controlled by the `y1` parameter.
 *
 * @receiver DrawScope The scope within which drawing operations are performed.
 * This provides access to the current [Size] of the drawing area.
 *
 * @return A [Path] object representing the described shape.
 *
 * The path is composed by:
 * 1. A line from (0,0) to (width, 0)
 * 2. A line from (width,0) to (width, height - width/2)
 * 3. A quadratic curve from (width, height - width/2) to (0, height - width/2) with a control point of (width/2, height/1.1)
 * 4. A close call to connect the path to the origin (0,0)
 *
 */
private fun DrawScope.createOvalBottomPath(x1: Float, y1: Float, x2: Float, y2: Float): Path {
    val path = Path()
    path.moveTo(0f, 0f) // Top-left corner
    path.lineTo(size.width, 0f) // Top-right corner
    path.lineTo(size.width, size.height - size.width / 2) // Bottom-right corner (before oval)
    path.quadraticTo(
        x1 = size.width / x1,
        y1 = size.height/ y1,
        x2 = x2,
        y2 = size.height - size.width / y2
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