package xyz.malefic.compose.booster.node

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

class SpacerNode(
    var width: Int = 0,
    var height: Int = 0,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Spacer(
                androidx.compose.ui.Modifier
                    .width(width.dp)
                    .height(height.dp),
            )
        }
}
