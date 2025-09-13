package xyz.malefic.compose.booster.util

import xyz.malefic.compose.booster.grid.GridPosition

fun at(
    x: Int,
    y: Int,
    spanX: Int = 1,
    spanY: Int = 1,
) = GridPosition(x, y, spanX, spanY)
