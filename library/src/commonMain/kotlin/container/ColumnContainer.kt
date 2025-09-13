package xyz.malefic.compose.booster.container

import androidx.compose.runtime.*
import xyz.malefic.compose.booster.node.UINode

class ColumnContainer : UINode() {
    private val children = mutableStateListOf<UINode>()

    fun addChild(node: UINode): UINode {
        children.add(node)
        return node
    }

    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose column layout
            children.forEach { it.render()() }
        }
}
