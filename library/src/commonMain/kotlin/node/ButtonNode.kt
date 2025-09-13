package xyz.malefic.compose.booster.node

import androidx.compose.runtime.Composable

class ButtonNode(
    var text: String,
    var onClick: () -> Unit = {},
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose button
        }
}
