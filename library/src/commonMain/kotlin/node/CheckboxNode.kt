package xyz.malefic.compose.booster.node

import androidx.compose.runtime.*

class CheckboxNode(
    var checked: Boolean,
    var onCheckedChange: (Boolean) -> Unit = {},
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose checkbox
        }
}
