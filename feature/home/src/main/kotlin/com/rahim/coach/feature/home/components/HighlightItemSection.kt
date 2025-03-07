package com.rahim.coach.feature.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen

@Composable
fun HighlightsSection(items: List<HighlightItem>, modifier: Modifier = Modifier) {
    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current
    Box(
        modifier = modifier
            .padding(horizontal = space.gigantic)
            // Force the box to be tall enough to show 2 rows
            // while staying symmetrical; for example a square or 3:2 ratio:
            .aspectRatio(3f / 2f),
        contentAlignment = Alignment.Center
    ) {
        // 1) Draw your grid lines with triangular caps
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        ) {
            drawGridLinesWithTriangleCaps(
                gridRow = 2,
                gridColumn = 3,
                color = Color.LightGray,
                strokeWidth = 5f
            )
        }

        // 2) Overlay your icons/text using a LazyVerticalGrid with 3 columns
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            items(items) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(space.extraSmall)
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (item.isSelected) CaribbeanGreen else Color.Gray,
                        modifier = Modifier.size(size.extraLarge)
                    )
                    Spacer(modifier = Modifier.height(size.default))

                    Text(
                        text = item.label,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = fontSize.default,
                            color = if (item.isSelected) Color.Black else Color.Gray
                        ),
                    )
                }
            }
        }
    }
}

private fun DrawScope.drawGridLinesWithTriangleCaps(
    gridRow: Int,
    gridColumn: Int,
    color: Color,
    strokeWidth: Float,
) {
    val cellWidth = size.width / gridColumn
    val cellHeight = size.height / gridRow
    val triangleSize = strokeWidth * 4  // Triangle size based on the line thickness

    // Function to draw a triangle cap at a specific position
    fun drawTriangleCap(center: Offset, directionX: Float, directionY: Float, isVertical: Boolean) {
        val path = Path().apply {
            if (isVertical) {
                moveTo(center.x, center.y)  // Triangle tip
                lineTo(
                    center.x + directionX - triangleSize / 2,
                    center.y + directionY * triangleSize
                )  // Bottom-left
                lineTo(
                    center.x - directionX + triangleSize / 2,
                    center.y + directionY * triangleSize
                )  // Bottom-right // Right corner
                close()
            } else {
                moveTo(center.x, center.y)  // Triangle tip
                lineTo(
                    center.x + directionX * triangleSize,
                    center.y - (triangleSize / 2)
                )
                lineTo(
                    center.x + directionX * triangleSize,
                    center.y + (triangleSize / 2)
                )
                close()
            }
        }
        drawPath(path, color)
    }

    val lineOffset = 70f

    // Draw vertical lines with triangle caps
    for (i in 0..gridColumn) {
        val x = i * cellWidth
        drawLine(
            color = color,
            start = Offset(x, -lineOffset),
            end = Offset(x, size.height + lineOffset),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        // Top and bottom triangle caps
        drawTriangleCap(
            center = Offset(x, -lineOffset),
            directionX = 0f,
            directionY = -1f,
            isVertical = true
        )  // Pointing down
        drawTriangleCap(
            center = Offset(x, size.height + lineOffset),
            directionX = 0f,
            directionY = 1f,
            isVertical = true
        )  // Pointing up
    }

    // Draw horizontal lines with triangle caps
    for (i in 0..gridRow) {
        val y = i * cellHeight
        drawLine(
            color = color,
            start = Offset(-lineOffset, y),
            end = Offset(size.width + lineOffset, y),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        // Left and right triangle caps
        drawTriangleCap(
            center = Offset(-lineOffset, y),
            directionX = -1f,
            directionY = 0f,
            isVertical = false
        )  // Pointing right
        drawTriangleCap(
            center = Offset(size.width + lineOffset, y),
            directionX = 1f,
            directionY = 0f,
            isVertical = false
        )  // Pointing left
    }
}

@Preview(showBackground = true)
@Composable
fun TriangleCapPreview() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val gridSize = 3
        val cellWidth = canvasWidth / gridSize
        val cellHeight = canvasHeight / gridSize
        val triangleSize = 20.dp.toPx()

        // Function to draw a triangle cap at a specific position
        fun drawTriangleCap(
            center: Offset,
            directionX: Float,
            directionY: Float,
            isVertical: Boolean,
        ) {
            val path = Path().apply {
                if (isVertical) {
                    moveTo(center.x, center.y)  // Triangle tip
                    lineTo(
                        center.x + directionX - triangleSize / 2,
                        center.y + directionY * triangleSize
                    )  // Bottom-left
                    lineTo(
                        center.x - directionX + triangleSize / 2,
                        center.y + directionY * triangleSize
                    )  // Bottom-right // Right corner
                    close()
                } else {
                    moveTo(center.x, center.y)  // Triangle tip
                    lineTo(
                        center.x + directionX * triangleSize,
                        center.y - (triangleSize / 2)
                    )
                    lineTo(
                        center.x + directionX * triangleSize,
                        center.y + (triangleSize / 2)
                    )
                    close()
                }
            }
            drawPath(path, Color.Red)
        }

        // Draw vertical lines with upward/downward-facing triangles
        for (i in 1 until gridSize) {
            val x = i * cellWidth
            drawLine(
                color = Color.Gray,
                start = Offset(x, 0f),
                end = Offset(x, canvasHeight),
                strokeWidth = 5.dp.toPx()
            )
            // Top and bottom triangle caps
            drawTriangleCap(
                center = Offset(x, 0f),
                directionX = 0f,
                directionY = -1f,
                isVertical = true
            )  // Pointing down
            drawTriangleCap(
                center = Offset(x, canvasHeight),
                directionX = 0f,
                directionY = 1f,
                isVertical = true
            )  // Pointing up
        }

        // Draw horizontal lines with inward-facing triangles
        for (i in 1 until gridSize) {
            val y = i * cellHeight
            drawLine(
                color = Color.Gray,
                start = Offset(0f, y),
                end = Offset(canvasWidth, y),
                strokeWidth = 5.dp.toPx()
            )
            // Left and right triangle caps
            drawTriangleCap(
                center = Offset(0f, y),
                directionX = -1f,
                directionY = 0f,
                isVertical = false
            )  // Pointing right
            drawTriangleCap(
                center = Offset(canvasWidth, y),
                directionX = 1f,
                directionY = 0f,
                isVertical = false
            )  // Pointing left
        }
    }
}