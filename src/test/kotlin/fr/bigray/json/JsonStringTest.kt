package fr.bigray.json

import org.junit.Test

import org.junit.Assert.*

class JsonStringTest {

    @Test
    fun toJson() {
        val actual1 = JsonString()
        val actual2 = JsonString(" test JsonString ")

        assertEquals("\"null\"", actual1.toJson())
        assertEquals("\"test JsonString\"", actual2.toJson())

    }

    @Test
    fun `to String`() {
    }

    @Test
    fun equals() {
    }

    @Test
    fun getValue() {
    }
}