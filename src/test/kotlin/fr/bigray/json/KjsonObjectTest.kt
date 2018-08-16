package fr.bigray.json

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KjsonObjectTest {

    private lateinit var kjson: KjsonObject

    @BeforeTest
    fun init() {
        val address = KjsonObject.createObject()
                .en("number", 4)
                .en("zipCode", KjsonNumber(17540))
                .en("street", "Chemin de la gare")
                .en("city", KjsonString("Le Gué d'Alleré"))
                .en("digiCode", null)

        kjson = KjsonObject.createObject()
                .en("firstName", KjsonString("John"))
                .en("lastName", KjsonString("Doe"))
                .en("age", KjsonNumber(40))
                .en("isStrong", KjsonBoolean(true))
                .en("address", KjsonObject.createObject()
                        .allEn(address))
                .en("hobbies", KjsonArray.createArray()
                        .el("F1")
                        .el("Rally")
                        .el("Music"))
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

        assertTrue(actual.size == kjson.size)

        assertTrue(actual["firstName"] is KjsonString)
        assertEquals(expected = "John", actual = actual["firstName"]?.value)

        assertTrue(actual["age"] is KjsonNumber)
        assertEquals(40.toBigDecimal(), actual["age"]?.value)

        assertTrue(actual["isStrong"] is KjsonBoolean)
        assertTrue(actual["isStrong"]?.value as Boolean)

        assertTrue(actual["address"] is KjsonObject)
        assertEquals(5, actual["address"]?.asKjsonObject()?.size)

        assertTrue(actual["hobbies"] is KjsonArray)
        assertEquals(3, actual["hobbies"]?.asKjsonArray()?.size)

    }

}