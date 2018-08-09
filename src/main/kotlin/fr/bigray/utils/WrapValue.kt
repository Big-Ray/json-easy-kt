package fr.bigray.utils

import fr.bigray.json.*

object WrapValue {
    fun wrap(value: Any?): JsonValue {
        return when (value) {
            is JsonValue -> value
            is String -> JsonString(value)
            is Number -> JsonNumber(value)
            is Boolean -> JsonBoolean(value)
            null -> JsonNull.NULL
            else -> throw Exception("Unknown json type.")
        }
    }

    fun wrapStringValue(value: String): JsonValue {
        return when {
            isBoolean(value) -> JsonBoolean(value.toBoolean())
            isNull(value) -> JsonNull()
            isNumber(value) -> JsonNumber(value.toBigDecimal())
            else -> JsonString(value)
        }
    }

    private val isNumber = { value: String -> value.toBigDecimal().let { true } }
    private val isBoolean = { value: String -> value.toBoolean() || java.lang.Boolean.FALSE.toString() == value }
    private val isNull = { value: String? -> value.isNullOrEmpty() || value == "null" }

}