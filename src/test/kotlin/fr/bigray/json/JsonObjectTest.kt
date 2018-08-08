package fr.bigray.json

import kotlin.test.*

class JsonObjectTest {

    private lateinit var actual: JsonObject

    @BeforeTest
    fun init() {
        val address = JsonObject.createObject()
                .en("number", 4)
                .en("zipCode", JsonNumber(17540))
                .en("street", "Chemin de la gare")
                .en("city", JsonString("Le Gué d'Alleré"))
                .en("digiCode", null)

        actual = JsonObject.createObject()
                .en("firstName", JsonString("John"))
                .en("lastName", JsonString("Doe"))
                .en("age", JsonNumber(40))
                .en("isStrong", JsonBoolean(true))
                .en("address", JsonObject.createObject()
                        .allEn(address))
                .en("hobbies", JsonArray.createArray()
                        .el("F1")
                        .el("Rally")
                        .el("Music"))
    }

    @Test
    fun toJson() {

        val expectedJson = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":40,\"isStrong\":true,\"address\":{\"number\":4,\"zipCode\":17540,\"street\":\"Chemin de la gare\",\"city\":\"Le Gué d'Alleré\",\"digiCode\":null},\"hobbies\":[\"F1\",\"Rally\",\"Music\"]}"

        assertEquals(expectedJson, actual.toJson())

    }

}