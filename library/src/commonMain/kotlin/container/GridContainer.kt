package xyz.malefic.compose.booster.container

import androidx.compose.runtime.*
import xyz.malefic.compose.booster.grid.*
import xyz.malefic.compose.booster.node.*

class GridContainer : UINode() {
    var gridConfig by mutableStateOf(GridConfig(rows = 10, columns = 10))
    private val children = mutableStateListOf<UINode>()
    private val gridOccupancy = mutableStateMapOf<Pair<Int, Int>, Int>()

    fun build(block: GridContainerBuilder.() -> Unit) {
        val builder = GridContainerBuilder(this)
        builder.block()
    }

    internal fun addChild(
        node: UINode,
        position: GridPosition,
    ): UINode {
        require(position.startX + position.spanX <= gridConfig.columns) { "Node exceeds grid width" }
        require(position.startY + position.spanY <= gridConfig.rows) { "Node exceeds grid height" }
        checkGridCollision(position)
        node.gridPosition = position
        val childIndex = children.size
        children.add(node)
        markGridOccupied(childIndex, position)
        return node
    }

    fun changeGrid(newConfig: GridConfig) {
        gridConfig = newConfig
    }

    private fun checkGridCollision(position: GridPosition) {
        for (x in position.startX until position.startX + position.spanX) {
            for (y in position.startY until position.startY + position.spanY) {
                if (gridOccupancy.containsKey(Pair(x, y))) {
                    throw IllegalArgumentException("Grid position ($x, $y) already occupied")
                }
            }
        }
    }

    private fun markGridOccupied(
        childIndex: Int,
        position: GridPosition,
    ) {
        for (x in position.startX until position.startX + position.spanX) {
            for (y in position.startY until position.startY + position.spanY) {
                gridOccupancy[Pair(x, y)] = childIndex
            }
        }
    }

    override fun render(): @Composable () -> Unit =
        {
            children.forEach { child ->
                if (child.modifier.visible) child.render()()
            }
        }
}
