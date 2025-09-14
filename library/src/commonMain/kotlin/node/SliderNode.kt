package xyz.malefic.compose.booster.node

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable

class SliderNode(
    var value: Float,
    var onValueChange: (Float) -> Unit = {},
    var min: Float = 0f,
    var max: Float = 1f,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Slider(
                value = value,
                onValueChange = { newValue ->
                    value = newValue
                    onValueChange(newValue)
                },
                valueRange = min..max,
                enabled = modifier.enabled,
                colors =
                    SliderDefaults.colors(
                        thumbColor = modifier.backgroundColor ?: androidx.compose.material3.MaterialTheme.colorScheme.primary,
                        activeTrackColor = modifier.backgroundColor ?: androidx.compose.material3.MaterialTheme.colorScheme.primary,
                        inactiveTrackColor =
                            modifier.backgroundColor?.copy(alpha = 0.3f)
                                ?: androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
                    ),
            )
        }
}
