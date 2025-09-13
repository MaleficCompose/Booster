package xyz.malefic.compose.booster.modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Styles {
    val primaryButton =
        UIModifier()
            .backgroundColor(Color.Blue)
            .textColor(Color.White)
            .padding(16)
            .borderRadius(8)
            .clickable()
            .hoverable(Color.Blue.copy(alpha = 0.8f))

    val secondaryButton =
        UIModifier()
            .backgroundColor(Color.Gray)
            .textColor(Color.Black)
            .padding(12)
            .borderRadius(4)
            .clickable()

    val title =
        UIModifier()
            .fontSize(24.sp)
            .fontWeight(FontWeight.Bold)
            .textColor(Color.Black)

    val subtitle =
        UIModifier()
            .fontSize(16.sp)
            .fontWeight(FontWeight.Medium)
            .textColor(Color.Gray)

    val card =
        UIModifier()
            .backgroundColor(Color.White)
            .border(Color.LightGray, 1)
            .borderRadius(8)
            .padding(16)

    val fullWidth =
        UIModifier()
            .width(Int.MAX_VALUE)
}
