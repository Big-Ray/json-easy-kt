package fr.bigray.kjson

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KjsonObjectTest {

    private lateinit var kjson: KjsonObject

    @BeforeTest
    fun init() {
        val address = KjsonObjectBuilder()
                .add("number", 4)
                .add("zipCode", KjsonNumber(17540))
                .add("street", "Chemin de la gare")
                .add("city", KjsonString("Le Gué d'Alleré"))
                .add("digiCode", null)
                .create()

        kjson = KjsonObjectBuilder()
                .add("firstName", KjsonString("John"))
                .add("lastName", KjsonString("Doe"))
                .add("age", KjsonNumber(40))
                .add("isStrong", KjsonBoolean(true))
                .add("address", KjsonObjectBuilder()
                        .addAll(address).create())
                .add("hobbies", KjsonArrayBuilder()
                        .add("F1")
                        .add("Rally")
                        .add("Music").create())
                .create()
    }

    @Test
    fun toJson() {

        val expectedJson = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":40,\"isStrong\":true,\"address\":{\"number\":4,\"zipCode\":17540,\"street\":\"Chemin de la gare\",\"city\":\"Le Gué d'Alleré\",\"digiCode\":null},\"hobbies\":[\"F1\",\"Rally\",\"Music\"]}"

        assertEquals(expectedJson, kjson.toJson())

    }

    @Test
    fun fromJson() {
        val json = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":40,\"isStrong\":true,\"address\":{\"number\":4,\"zipCode\":17540,\"street\":\"Chemin de la gare\",\"city\":\"Le Gué d'Alleré\",\"digiCode\":null},\"hobbies\":[\"F1\",\"Rally\",\"Music\"]}"
        val actual = KjsonObject.fromJson(json)

//        assertTrue(actual.value.contains())

        assertTrue(actual.get("firstName") is KjsonString)
        assertEquals(expected = "John", actual = actual.get("firstName")?.value)
//
//        assertTrue(actual["age"] is KjsonNumber)
//        assertEquals(40.toBigDecimal(), actual["age"]?.value)
//
//        assertTrue(actual["isStrong"] is KjsonBoolean)
//        assertTrue(actual["isStrong"]?.value as Boolean)
//
//        assertTrue(actual["address"] is KjsonObject)
//        assertEquals(5, actual["address"]?.asObject()?.size)
//
//        assertTrue(actual["hobbies"] is KjsonArray)
//        assertEquals(3, actual["hobbies"]?.asArray()?.size)

    }

}