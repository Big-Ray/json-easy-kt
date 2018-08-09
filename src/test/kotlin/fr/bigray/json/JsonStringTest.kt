package fr.bigray.json

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class JsonStringTest {

    @Test
    fun toJson() {
        val actual1 = JsonString()
        val actual2 = JsonString(" test JsonString ")

        assertEquals("\"null\"", actual1.toJson())
        assertEquals("\"test JsonString\"", actual2.toJson())

    }

    @Test
    fun equals() {
        val actual1 = JsonString("value")
        val actual2 = JsonString("value")

        assertTrue(actual1 == actual2)
    }

}