package xyz.malefic.compose.booster.node

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class TextNode(
    var content: String,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Text(
                text = content,
                color = modifier.textColor ?: Color.Unspecified,
                fontSize = modifier.fontSize ?: 14.sp,
                fontWeight = modifier.fontWeight ?: FontWeight.Normal,
            )
        }
}
