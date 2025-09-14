package xyz.malefic.compose.booster.container

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.*
import xyz.malefic.compose.booster.node.UINode

class RowContainer : UINode() {
    private val children = mutableStateListOf<UINode>()

    fun addChild(node: UINode): UINode {
        children.add(node)
        return node
    }

    fun build(block: RowContainerBuilder.() -> Unit) {
        val builder = RowContainerBuilder(this)
        builder.block()
    }

    override fun render(): @Composable () -> Unit =
        {
            Row(
                modifier =
                    androidx.compose.ui.Modifier
                        .fillMaxHeight(),
            ) {
                children.forEach { child ->
                    if (child.modifier.visible) {
                        child.render()()
                    }
                }
            }
        }
}
