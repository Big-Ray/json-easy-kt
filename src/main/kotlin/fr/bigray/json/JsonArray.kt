package fr.bigray.json

import fr.bigray.parser.JsonParser
import fr.bigray.utils.WrapValue

class JsonArray private constructor() : ArrayList<JsonValue>(), JsonValue {
    override val value: JsonArray
        get() = this

    override fun toJson(): String = this.joinToString(prefix = "[", postfix = "]", separator = ",") { it.toJson() }

    companion object {
        fun createArray(): JsonArray = JsonArray()
        fun fromJson(json: String): JsonArray = JsonParser.parse(json) as JsonArray
    }

    fun el(entry: Any?): JsonArray {
        this.add(WrapValue.wrap(entry))
        return this
    }

    fun allEl(entries: List<JsonValue>): JsonArray {
        this.addAll(entries)
        return this
    }


}
