package fr.bigray.json

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class JsonBooleanTest {

    @Test
    fun toJson() {
        val actual = JsonBoolean(false)

        assertEquals("false", actual.toJson())
    }

    @Test
    fun `to string`() {
        val actual = JsonBoolean(false)

        assertEquals("JsonBoolean(value=false)", actual.toString())
    }

    @Test
    fun equals() {
        val actual1 = JsonBoolean(false)
        val actual2 = JsonBoolean(false)

        assertTrue(actual1.equals(actual2))
    }

    @Test
    fun getValue() {
        val actual = JsonBoolean(true)

        assertTrue(actual.value)
    }
}