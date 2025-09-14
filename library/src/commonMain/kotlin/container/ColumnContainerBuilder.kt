package xyz.malefic.compose.booster.container

import androidx.compose.runtime.Composable
import xyz.malefic.compose.booster.modifier.UIModifier
import xyz.malefic.compose.booster.node.*

class ColumnContainerBuilder(
    private val container: ColumnContainer,
) {
    fun button(
        text: String,
        onClick: () -> Unit = {},
        modifier: UIModifier.() -> UIModifier = { this },
    ): ButtonNode {
        val button = ButtonNode(text, onClick)
        button.modifier = UIModifier().modifier()
        container.addChild(button)
        return button
    }

    fun text(
        content: String,
        modifier: UIModifier.() -> UIModifier = { this },
    ): TextNode {
        val textNode = TextNode(content)
        textNode.modifier = UIModifier().modifier()
        container.addChild(textNode)
        return textNode
    }

    fun input(
        placeholder: String = "",
        modifier: UIModifier.() -> UIModifier = { this },
        onValueChange: (String) -> Unit = {},
    ): InputNode {
        val inputNode = InputNode(placeholder, onValueChange)
        inputNode.modifier = UIModifier().modifier()
        container.addChild(inputNode)
        return inputNode
    }

    fun spacer(
        width: Int = 0,
        height: Int = 8,
    ): SpacerNode {
        val spacer = SpacerNode(width, height)
        container.addChild(spacer)
        return spacer
    }

    fun divider(
        thickness: Int = 1,
        modifier: UIModifier.() -> UIModifier = { this },
    ): DividerNode {
        val dividerNode = DividerNode(DividerNode.Orientation.Horizontal, thickness)
        dividerNode.modifier = UIModifier().modifier()
        container.addChild(dividerNode)
        return dividerNode
    }

    fun card(
        elevation: Int = 4,
        modifier: UIModifier.() -> UIModifier = { this },
        content: @Composable () -> Unit = {},
    ): CardNode {
        val cardNode = CardNode(content, elevation)
        cardNode.modifier = UIModifier().modifier()
        container.addChild(cardNode)
        return cardNode
    }
}
