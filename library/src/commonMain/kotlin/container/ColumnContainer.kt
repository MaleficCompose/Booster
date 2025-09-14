package xyz.malefic.compose.booster.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import xyz.malefic.compose.booster.node.UINode

class ColumnContainer : UINode() {
    private val children = mutableStateListOf<UINode>()

    fun addChild(node: UINode): UINode {
        children.add(node)
        return node
    }

    fun build(block: ColumnContainerBuilder.() -> Unit) {
        val builder = ColumnContainerBuilder(this)
        builder.block()
    }

    override fun render(): @Composable () -> Unit =
        {
            Column(
                modifier =
                    androidx.compose.ui.Modifier
                        .fillMaxWidth(),
            ) {
                children.forEach { child ->
                    if (child.modifier.visible) {
                        child.render()()
                    }
                }
            }
        }
}
