package xyz.malefic.compose.booster.container

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import xyz.malefic.compose.booster.node.UINode

class StackContainer : UINode() {
    private val children = mutableStateListOf<UINode>()

    fun addChild(node: UINode): UINode {
        children.add(node)
        return node
    }

    override fun render(): @Composable () -> Unit =
        {
            Box(
                modifier =
                    androidx.compose.ui.Modifier
                        .fillMaxSize(),
            ) {
                children.forEach { child ->
                    if (child.modifier.visible) {
                        child.render()()
                    }
                }
            }
        }
}
