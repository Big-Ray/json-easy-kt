package fr.bigray.json

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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

        assertTrue(actual1 == actual2)
    }

}