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
            stringIsBoolean(value) -> JsonBoolean(value.toBoolean())
            stringIsNull(value) -> JsonNull()
            stringIsNumber(value) -> JsonNumber(value.toBigDecimal())
            else -> JsonString(value)
        }
    }

    private fun stringIsNumber(value: String): Boolean {
        try {
            value.toBigDecimal()
        } catch (e: NumberFormatException) {
            return false
        }

        return true
    }

    private fun stringIsBoolean(value: String): Boolean {
        return value.toBoolean() || java.lang.Boolean.FALSE.toString() == value
    }

    private fun stringIsNull(value: String?): Boolean {
        return value.isNullOrEmpty() || value == "null"
    }
}