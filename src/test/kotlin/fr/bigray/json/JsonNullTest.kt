package fr.bigray.json

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class JsonNullTest {

    private lateinit var actual: JsonNull

    @Before
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
    fun `to String`() {
        assertEquals("JsonNull()", actual.toString())
    }

    @Test
    fun equals() {
        val otherNull: JsonNull = JsonNull.NULL
        assertTrue(actual.equals(otherNull))
    }
}