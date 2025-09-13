package xyz.malefic.compose.booster.node

import androidx.compose.runtime.*

class ProgressNode(
    var value: Float,
    var max: Float = 1f,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose progress bar
        }
}
