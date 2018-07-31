package fr.bigray.json

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class JsonNumberTest {

    @Test
    fun toJson() {
        val actual1 = JsonNumber(1234)
        val actual2 = JsonNumber(12.34)
        val actual3 = JsonNumber(12L)
        val actual4 = JsonNumber(12.236985)

        assertEquals(1234, actual1.value)
        assertEquals("1234", actual1.toJson())

        assertEquals(12.34, actual2.value)
        assertEquals("12.34", actual2.toJson())

        assertEquals(12L, actual3.value)
        assertEquals("12", actual3.toJson())

        assertEquals(12.236985, actual4.value)
        assertEquals("12.236985", actual4.toJson())
    }

    @Test
    fun equals() {
        val actual1 = JsonNumber(12.34)
        val actual2 = JsonNumber(12.34)

        assertTrue(actual1.equals(actual2))
    }

    @Test
    fun `to string`() {
        val actual = JsonNumber(12.34)
        assertEquals("JsonNumber(value=12.34)", actual.toString())
    }
}