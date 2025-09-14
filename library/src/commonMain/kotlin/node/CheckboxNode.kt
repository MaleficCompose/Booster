package xyz.malefic.compose.booster.node

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.*

class CheckboxNode(
    var checked: Boolean,
    var onCheckedChange: (Boolean) -> Unit = {},
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Checkbox(
                checked = checked,
                onCheckedChange = { newChecked ->
                    checked = newChecked
                    onCheckedChange(newChecked)
                },
                enabled = modifier.enabled,
                colors =
                    CheckboxDefaults.colors(
                        checkedColor = modifier.backgroundColor ?: androidx.compose.material3.MaterialTheme.colorScheme.primary,
                        uncheckedColor = modifier.borderColor ?: androidx.compose.material3.MaterialTheme.colorScheme.outline,
                    ),
            )
        }
}
