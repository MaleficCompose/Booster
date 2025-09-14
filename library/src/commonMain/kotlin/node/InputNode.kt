package xyz.malefic.compose.booster.node

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
            OutlinedTextField(
                value = value,
                onValueChange = { newValue ->
                    value = newValue
                    onValueChange(newValue)
                },
                label = { Text(placeholder) },
                enabled = modifier.enabled,
                singleLine = true,
            )
        }
}
