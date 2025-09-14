package xyz.malefic.compose.booster.node

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*

class ProgressNode(
    var value: Float,
    var max: Float = 1f,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            val progress = if (max > 0) value / max else 0f
            LinearProgressIndicator(
                progress = { progress.coerceIn(0f, 1f) },
                color = modifier.backgroundColor ?: androidx.compose.material3.MaterialTheme.colorScheme.primary,
                trackColor =
                    modifier.backgroundColor?.copy(alpha = 0.3f) ?: androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
            )
        }
}
