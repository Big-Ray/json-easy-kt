package fr.bigray.utils

import fr.bigray.json.*
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

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

        val aValueNotKnown = listOf<Pair<*, *>>()

        assertTrue(WrapValue.wrap(jsonObject) is JsonObject)
        assertTrue(WrapValue.wrap(jsonArray) is JsonArray)
        assertTrue(WrapValue.wrap(aString) is JsonString)
        assertTrue(WrapValue.wrap(integer) is JsonNumber)
        assertTrue(WrapValue.wrap(bigDecimal) is JsonNumber)
        assertTrue(WrapValue.wrap(bigInteger) is JsonNumber)
        assertTrue(WrapValue.wrap(aDouble) is JsonNumber)
        assertTrue(WrapValue.wrap(aLong) is JsonNumber)
        assertTrue(WrapValue.wrap(aBoolean) is JsonBoolean)

        assertFailsWith(Exception::class) { WrapValue.wrap(aValueNotKnown) }

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