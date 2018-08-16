package fr.bigray.kjson

import fr.bigray.parser.KjsonParser

object Kjson {
    @JvmStatic
    fun fromJson(json: String): KjsonValue =
            when {
                json.startsWith("{") -> KjsonParser.parse(json) as KjsonObject
                json.startsWith("[") -> KjsonParser.parse(json) as KjsonArray
                else -> {
                    throw RuntimeException("ERROR: Not a valid json")
                }
            }

    @JvmStatic
    fun toJson(jsonValue: KjsonValue): String = jsonValue.toJson()
}