package fr.bigray.kjson

import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class KjsonArrayTest {

//    @Test
//    fun toJson() {
//
//        val arr1 = KjsonArray.createArray()
//                .el("arr1")
//                .el(12)
//
//        val obj1 = KjsonObject.createObject()
//                .en("firstName", "Mick")
//                .en("lastName", "Tyson")
//                .en("age", 55)
//                .en("hobbies", KjsonArray.createArray()
//                        .el("Boxe")
//                        .el("Catch")
//                        .el("Movies"))
//
//        val obj2 = KjsonObject.createObject()
//                .en("firstName", "Alain")
//                .en("lastName", "Prost")
//                .en("age", 65)
//                .en("hobbies", KjsonArray.createArray()
//                        .el("F1")
//                        .el("Rally")
//                        .el("Music"))
//
//        val obj3 = KjsonObject.createObject()
//                .en("firstName", "Big")
//                .en("lastName", "Ray")
//                .en("age", 40)
//                .en("hobbies", KjsonArray.createArray()
//                        .el("guitar")
//                        .el("basket ball"))
//
//        val actual = KjsonArray.createArray()
//                .el(obj1)
//                .el(obj2)
//                .el(obj3)
//                .el("string value")
//                .el(BigDecimal(3456))
//                .el(BigInteger("1", 3))
//                .el(123)
//                .el(123.56)
//                .el(1234567L)
//                .el(null)
//                .allEl(arr1)
//
//        val expected = "[{\"firstName\":\"Mick\",\"lastName\":\"Tyson\",\"age\":55,\"hobbies\":[\"Boxe\",\"Catch\",\"Movies\"]},{\"firstName\":\"Alain\",\"lastName\":\"Prost\",\"age\":65,\"hobbies\":[\"F1\",\"Rally\",\"Music\"]},{\"firstName\":\"Big\",\"lastName\":\"Ray\",\"age\":40,\"hobbies\":[\"guitar\",\"basket ball\"]},\"string value\",3456,1,123,123.56,1234567,null,\"arr1\",12]"
//
//        assertEquals(expected, actual.toJson())
//    }
//
//    @Test
//    fun fromJson() {
//        val json = "[{\"firstName\":\"Mick\",\"lastName\":\"Tyson\",\"age\":55,\"hobbies\":[\"Boxe\",\"Catch\",\"Movies\"]},\"string value\",3456,null,[\"arr1\",12]]"
//        val actual = KjsonArray.fromJson(json)
//
//        val expected = KjsonArray.createArray()
//                .el(KjsonObject.createObject()
//                        .en("firstName", "Mick")
//                        .en("lastName", "Tyson")
//                        .en("age", 55)
//                        .en("hobbies", KjsonArray.createArray()
//                                .el("Boxe")
//                                .el("Catch")
//                                .el("Movies")))
//                .el("string value")
//                .el(BigDecimal(3456))
//                .el(null)
//                .el(KjsonArray.createArray()
//                        .el("arr1")
//                        .el(12))
//
//        assertTrue(actual.containsAll(expected))
//
//    }
//
//    @Test
//    fun fromJson_nominal_case() {
//        val json = "[ \"value1\", \"value2\", true, null, 4 ]"
//        val actual = KjsonArray.fromJson(json)
//
//        val expected = KjsonArray.createArray()
//                .el("value1")
//                .el("value2")
//                .el(true)
//                .el(null)
//                .el(4)
//
//        assertTrue(actual.containsAll(expected))
//
//        assertEquals(5, actual.size)
//        assertTrue(actual[0] is KjsonString)
//        assertEquals("value1", actual[0].value)
//
//        assertTrue(actual[1] is KjsonString)
//        assertEquals("value2", actual[1].value)
//
//        assertTrue(actual[2] is KjsonBoolean)
//        assertTrue(actual[2].value as Boolean)
//
//        assertTrue(actual[3] is KjsonNull)
//        assertNull(actual[3].value)
//
//        assertTrue(actual[4] is KjsonNumber)
//        assertEquals(4.toBigDecimal(), actual[4].value)
//
//    }

}