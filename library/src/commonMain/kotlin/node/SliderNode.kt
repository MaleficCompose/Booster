package xyz.malefic.compose.booster.node

import androidx.compose.runtime.Composable

class SliderNode(
    var value: Float,
    var onValueChange: (Float) -> Unit = {},
    var min: Float = 0f,
    var max: Float = 1f,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose slider
        }
}
