package xyz.malefic.compose.booster.node

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class DividerNode(
    var orientation: Orientation = Orientation.Horizontal,
    var thickness: Int = 1,
    var color: Color? = null,
) : UINode() {
    enum class Orientation {
        Horizontal,
        Vertical,
    }

    override fun render(): @Composable () -> Unit =
        {
            when (orientation) {
                Orientation.Horizontal ->
                    HorizontalDivider(
                        thickness = thickness.dp,
                        color = color ?: androidx.compose.material3.MaterialTheme.colorScheme.outline,
                    )
                Orientation.Vertical ->
                    VerticalDivider(
                        thickness = thickness.dp,
                        color = color ?: androidx.compose.material3.MaterialTheme.colorScheme.outline,
                    )
            }
        }
}
