package fr.bigray.json

import kotlin.test.*

class JsonNullTest {

    private lateinit var actual: JsonNull

    @BeforeTest
    fun init() {
        actual = JsonNull.NULL
    }

    @Test
    fun getValue() {
        assertNull(actual.value)
    }

    @Test
    fun toJson() {
        assertEquals("null", actual.toJson())
    }

    @Test
    fun equals() {
        val otherNull: JsonNull = JsonNull.NULL
        assertTrue(actual == otherNull)
    }
}