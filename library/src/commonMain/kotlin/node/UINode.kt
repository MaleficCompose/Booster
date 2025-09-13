package xyz.malefic.compose.booster.node

import androidx.compose.runtime.*
import xyz.malefic.compose.booster.grid.GridPosition
import xyz.malefic.compose.booster.modifier.UIModifier

abstract class UINode {
    var gridPosition by mutableStateOf<GridPosition?>(null)
    var modifier by mutableStateOf(UIModifier())

    abstract fun render(): @Composable () -> Unit

    fun styled(block: UIModifier.() -> UIModifier): UINode {
        modifier = modifier.block()
        return this
    }
}
