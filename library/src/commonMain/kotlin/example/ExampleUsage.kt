package xyz.malefic.compose.booster.example

import xyz.malefic.compose.booster.container.*
import xyz.malefic.compose.booster.grid.GridPosition
import xyz.malefic.compose.booster.modifier.Styles

/**
 * Example usage demonstrating the library's API.
 * This file serves as a validation of the implementations and showcases the library usage.
 */
object ExampleUsage {
    
    fun createGridExample(): GridContainer {
        val container = GridContainer()
        container.build {
            grid(rows = 5, columns = 3)
            
            text("Title", at = GridPosition(0, 0)) {
                Styles.title
            }
            
            button("Click Me", at = GridPosition(1, 0), onClick = {
                println("Button clicked!")
            }) {
                Styles.primaryButton
            }
            
            input("Enter text", at = GridPosition(2, 0), onValueChange = { value ->
                println("Input changed: $value")
            })
            
            progress(0.75f, at = GridPosition(3, 0))
            
            slider(0.5f, at = GridPosition(4, 0), onValueChange = { value ->
                println("Slider value: $value")
            })
            
            checkbox(true, at = GridPosition(0, 1), onCheckedChange = { checked ->
                println("Checkbox: $checked")
            })
            
            divider(at = GridPosition(1, 1))
            
            spacer(at = GridPosition(2, 1), width = 50, height = 20)
        }
        return container
    }
    
    fun createColumnExample(): ColumnContainer {
        val container = ColumnContainer()
        container.build {
            text("Welcome to Column Layout") {
                Styles.title
            }
            
            spacer(height = 16)
            
            button("Action 1") {
                Styles.primaryButton
            }
            
            button("Action 2") {
                Styles.secondaryButton
            }
            
            divider()
            
            input("Type here...", onValueChange = { value ->
                println("Column input: $value")
            })
        }
        return container
    }
    
    fun createRowExample(): RowContainer {
        val container = RowContainer()
        container.build {
            button("Left") {
                Styles.primaryButton
            }
            
            spacer(width = 16)
            
            text("Middle Text") {
                Styles.subtitle
            }
            
            spacer(width = 16)
            
            button("Right") {
                Styles.secondaryButton
            }
        }
        return container
    }
    
    fun createStackExample(): StackContainer {
        val container = StackContainer()
        // Note: Stack containers don't have a builder pattern yet, 
        // but they can be used by adding children directly
        return container
    }
}