package xyz.malefic.compose.booster.grid

data class GridPosition(
    val startX: Int,
    val startY: Int,
    val spanX: Int = 1,
    val spanY: Int = 1,
) {
    init {
        require(startX >= 0 && startY >= 0) { "Grid positions must be non-negative" }
        require(spanX > 0 && spanY > 0) { "Grid spans must be positive" }
    }
}
