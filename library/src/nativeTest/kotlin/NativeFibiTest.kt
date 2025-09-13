package xyz.malefic.lib.fibonacci

import kotlin.test.Test
import kotlin.test.assertEquals

class NativeFibiTest {
    @Test
    fun `test 3rd element`() {
        assertEquals(12, generateFibi().take(3).last())
    }
}
