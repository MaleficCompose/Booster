package xyz.malefic.compose.booster.node

import androidx.compose.runtime.Composable

class TextNode(
    var content: String,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose text
        }
}
