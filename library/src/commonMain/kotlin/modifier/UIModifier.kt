package xyz.malefic.compose.booster.modifier

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

data class Padding(
    val left: Int = 0,
    val top: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0,
)

data class Margin(
    val left: Int = 0,
    val top: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0,
)

data class UIModifier(
    val width: Int? = null,
    val height: Int? = null,
    val padding: Padding = Padding(),
    val margin: Margin = Margin(),
    val alignment: Alignment = Alignment.Center,
    val backgroundColor: Color? = null,
    val borderColor: Color? = null,
    val borderWidth: Int = 0,
    val borderRadius: Int = 0,
    val opacity: Float = 1f,
    val textColor: Color? = null,
    val fontSize: TextUnit? = null,
    val fontWeight: FontWeight? = null,
    val textAlign: Alignment.Horizontal = Alignment.CenterHorizontally,
    val clickable: Boolean = false,
    val hoverable: Boolean = false,
    val hoverColor: Color? = null,
    val clickColor: Color? = null,
    val visible: Boolean = true,
    val enabled: Boolean = true,
) {
    fun width(width: Int) = copy(width = width)

    fun height(height: Int) = copy(height = height)

    fun size(
        width: Int,
        height: Int,
    ) = copy(width = width, height = height)

    fun padding(all: Int) = copy(padding = Padding(all, all, all, all))

    fun padding(
        horizontal: Int,
        vertical: Int,
    ) = copy(padding = Padding(horizontal, vertical, horizontal, vertical))

    fun padding(
        left: Int,
        top: Int,
        right: Int,
        bottom: Int,
    ) = copy(padding = Padding(left, top, right, bottom))

    fun margin(all: Int) = copy(margin = Margin(all, all, all, all))

    fun margin(
        horizontal: Int,
        vertical: Int,
    ) = copy(margin = Margin(horizontal, vertical, horizontal, vertical))

    fun backgroundColor(color: Color) = copy(backgroundColor = color)

    fun textColor(color: Color) = copy(textColor = color)

    fun fontSize(size: TextUnit) = copy(fontSize = size)

    fun fontWeight(weight: FontWeight) = copy(fontWeight = weight)

    fun border(
        color: Color,
        width: Int,
    ) = copy(borderColor = color, borderWidth = width)

    fun borderRadius(radius: Int) = copy(borderRadius = radius)

    fun opacity(alpha: Float) = copy(opacity = alpha)

    fun clickable() = copy(clickable = true)

    fun hoverable(hoverColor: Color? = null) = copy(hoverable = true, hoverColor = hoverColor)

    fun align(alignment: Alignment) = copy(alignment = alignment)

    fun hidden() = copy(visible = false)

    fun disabled() = copy(enabled = false)

    fun weight(weight: Float) = this // This would need to be handled in layout containers

    fun alpha(alpha: Float) = copy(opacity = alpha)

    fun fillMaxWidth() = copy(width = Int.MAX_VALUE)

    fun fillMaxHeight() = copy(height = Int.MAX_VALUE)

    fun fillMaxSize() = copy(width = Int.MAX_VALUE, height = Int.MAX_VALUE)
}
