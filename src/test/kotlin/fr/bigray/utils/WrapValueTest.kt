package fr.bigray.utils

import fr.bigray.json.*
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.math.BigInteger

class WrapValueTest {

    @Test
    fun wrap() {
        val jsonObject = JsonObject.createObject()
        val jsonArray = JsonArray.createArray()
        val aString = "str value"
        val integer = 1234
        val bigDecimal = BigDecimal(1234)
        val bigInteger = BigInteger("1", 3)
        val aDouble = 12.34
        val aLong = 1L
        val aBoolean = true

        assertTrue(WrapValue.wrap(jsonObject) is JsonObject)
        assertTrue(WrapValue.wrap(jsonArray) is JsonArray)
        assertTrue(WrapValue.wrap(aString) is JsonString)
        assertTrue(WrapValue.wrap(integer) is JsonNumber)
        assertTrue(WrapValue.wrap(bigDecimal) is JsonNumber)
        assertTrue(WrapValue.wrap(bigInteger) is JsonNumber)
        assertTrue(WrapValue.wrap(aDouble) is JsonNumber)
        assertTrue(WrapValue.wrap(aLong) is JsonNumber)
        assertTrue(WrapValue.wrap(aBoolean) is JsonBoolean)

    }

    @Test(expected = Exception::class)
    fun wrap_with_exception() {
        val aValueNotKnown = listOf<Pair<*, *>>()
        WrapValue.wrap(aValueNotKnown)
    }

    @Test
    fun wrapStringValue() {
        val stringIsNumber = "12"
        val stringIsTrueBoolean = "true"
        val stringIsFalseBoolean = "false"
        val stringIsNull = "null"

        assertTrue(WrapValue.wrapStringValue(stringIsNumber) is JsonNumber)
        assertTrue(WrapValue.wrapStringValue(stringIsTrueBoolean) is JsonBoolean)
        assertTrue(WrapValue.wrapStringValue(stringIsFalseBoolean) is JsonBoolean)
        assertTrue(WrapValue.wrapStringValue(stringIsNull) is JsonNull)
    }
}