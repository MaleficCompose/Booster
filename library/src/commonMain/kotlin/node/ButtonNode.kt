package xyz.malefic.compose.booster.node

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class ButtonNode(
    var text: String,
    var onClick: () -> Unit = {},
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Button(
                onClick = onClick,
                enabled = modifier.enabled,
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = modifier.backgroundColor ?: Color.Blue,
                        contentColor = modifier.textColor ?: Color.White,
                        disabledContainerColor = (modifier.backgroundColor ?: Color.Gray).copy(alpha = 0.5f),
                        disabledContentColor = (modifier.textColor ?: Color.White).copy(alpha = 0.5f),
                    ),
            ) {
                Text(
                    text = text,
                    fontSize = modifier.fontSize ?: 14.sp,
                    fontWeight = modifier.fontWeight,
                )
            }
        }
}
