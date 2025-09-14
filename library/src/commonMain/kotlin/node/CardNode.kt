package xyz.malefic.compose.booster.node

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class CardNode(
    var content: @Composable () -> Unit = {},
    var elevation: Int = 4,
) : UINode() {
    override fun render(): @Composable () -> Unit =
        {
            Card(
                modifier =
                    androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                colors =
                    CardDefaults.cardColors(
                        containerColor = modifier.backgroundColor ?: androidx.compose.material3.MaterialTheme.colorScheme.surface,
                    ),
                elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp),
            ) {
                content()
            }
        }
}
