package fr.bigray.json

import fr.bigray.parser.JsonParser
import fr.bigray.utils.WrapValue

class JsonObject private constructor() : LinkedHashMap<String, JsonValue>(), JsonValue {
    override val value: JsonObject
        get() = this

    override fun toJson(): String = this.entries.joinToString(prefix = "{", postfix = "}", separator = ",")
    { "\"${it.key}\":${it.value.toJson()}" }

    companion object {
        fun createObject(): JsonObject = JsonObject()
        fun fromJson(json: String): JsonObject = JsonParser.parse(json) as JsonObject
    }

    fun en(key: String, entry: Any?): JsonObject {
        this[key] = WrapValue.wrap(entry)
        return this
    }

    fun allEn(values: JsonObject): JsonObject {
        this.putAll(values)
        return this
    }

}
