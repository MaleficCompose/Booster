package xyz.malefic.compose.booster.container

import xyz.malefic.compose.booster.grid.GridConfig
import xyz.malefic.compose.booster.grid.GridPosition
import xyz.malefic.compose.booster.modifier.UIModifier
import xyz.malefic.compose.booster.node.*

class GridContainerBuilder(
    private val container: GridContainer,
) {
    fun button(
        text: String,
        at: GridPosition,
        onClick: () -> Unit = {},
        modifier: UIModifier.() -> UIModifier = { this },
    ): ButtonNode {
        val button = ButtonNode(text, onClick)
        button.modifier = UIModifier().modifier()
        container.addChild(button, at)
        return button
    }

    fun text(
        content: String,
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
    ): TextNode {
        val textNode = TextNode(content)
        textNode.modifier = UIModifier().modifier()
        container.addChild(textNode, at)
        return textNode
    }

    fun image(
        src: String,
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
    ): ImageNode {
        val imageNode = ImageNode(src)
        imageNode.modifier = UIModifier().modifier()
        container.addChild(imageNode, at)
        return imageNode
    }

    fun input(
        placeholder: String = "",
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
        onValueChange: (String) -> Unit = {},
    ): InputNode {
        val inputNode = InputNode(placeholder, onValueChange)
        inputNode.modifier = UIModifier().modifier()
        container.addChild(inputNode, at)
        return inputNode
    }

    fun slider(
        value: Float,
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
        onValueChange: (Float) -> Unit = {},
        min: Float = 0f,
        max: Float = 1f,
    ): SliderNode {
        val sliderNode = SliderNode(value, onValueChange, min, max)
        sliderNode.modifier = UIModifier().modifier()
        container.addChild(sliderNode, at)
        return sliderNode
    }

    fun checkbox(
        checked: Boolean,
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
        onCheckedChange: (Boolean) -> Unit = {},
    ): CheckboxNode {
        val checkboxNode = CheckboxNode(checked, onCheckedChange)
        checkboxNode.modifier = UIModifier().modifier()
        container.addChild(checkboxNode, at)
        return checkboxNode
    }

    fun progress(
        value: Float,
        at: GridPosition,
        modifier: UIModifier.() -> UIModifier = { this },
        max: Float = 1f,
    ): ProgressNode {
        val progressNode = ProgressNode(value, max)
        progressNode.modifier = UIModifier().modifier()
        container.addChild(progressNode, at)
        return progressNode
    }

    fun spacer(
        at: GridPosition,
        width: Int = 0,
        height: Int = 0,
    ): SpacerNode {
        val spacer = SpacerNode(width, height)
        container.addChild(spacer, at)
        return spacer
    }

    fun grid(
        rows: Int,
        columns: Int,
        cellWidth: Int = 100,
        cellHeight: Int = 100,
    ) {
        container.gridConfig = GridConfig(rows, columns, cellWidth, cellHeight)
    }

    fun divider(
        at: GridPosition,
        orientation: DividerNode.Orientation = DividerNode.Orientation.Horizontal,
        thickness: Int = 1,
        modifier: UIModifier.() -> UIModifier = { this },
    ): DividerNode {
        val dividerNode = DividerNode(orientation, thickness)
        dividerNode.modifier = UIModifier().modifier()
        container.addChild(dividerNode, at)
        return dividerNode
    }

    fun card(
        at: GridPosition,
        elevation: Int = 4,
        modifier: UIModifier.() -> UIModifier = { this },
        content: @androidx.compose.runtime.Composable () -> Unit = {},
    ): CardNode {
        val cardNode = CardNode(content, elevation)
        cardNode.modifier = UIModifier().modifier()
        container.addChild(cardNode, at)
        return cardNode
    }
}
