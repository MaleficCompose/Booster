package xyz.malefic.compose.booster.node

import androidx.compose.runtime.Composable

class ImageNode(
    var src: String,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose image
        }
}
