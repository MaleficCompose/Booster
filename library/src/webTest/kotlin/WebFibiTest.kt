package xyz.malefic.compose.booster

import kotlin.test.Test
import kotlin.test.assertEquals

class WebFibiTest {
    @Test
    fun `test 3rd element`() {
        assertEquals(11, generateFibi().take(3).last())
    }
}
