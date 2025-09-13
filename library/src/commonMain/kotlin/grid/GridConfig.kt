package xyz.malefic.compose.booster.grid

import androidx.compose.ui.unit.IntOffset

data class GridConfig(
    val rows: Int,
    val columns: Int,
    val cellWidth: Int = 100,
    val cellHeight: Int = 100,
) {
    init {
        require(rows > 0 && columns > 0) { "Grid must have positive dimensions" }
    }

    fun toPixelPosition(gridPos: GridPosition): IntOffset =
        IntOffset(
            x = gridPos.startX * cellWidth,
            y = gridPos.startY * cellHeight,
        )

    fun toPixelSize(gridPos: GridPosition): Pair<Int, Int> =
        Pair(
            gridPos.spanX * cellWidth,
            gridPos.spanY * cellHeight,
        )
}
