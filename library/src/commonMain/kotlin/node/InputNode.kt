package xyz.malefic.compose.booster.node

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class InputNode(
    var placeholder: String,
    var onValueChange: (String) -> Unit,
) : UINode() {
    var value by mutableStateOf("")

    override fun render(): @Composable () -> Unit =
        {
            // TODO: Compose input
        }
}
