package fr.bigray.utils

import fr.bigray.json.*

object WrapValue {
    fun wrap(value: Any?): JsonValue {
        if (value is JsonValue) {
            return value
        } else if (value is String) {
            return JsonString(value)
        } else if (value is Number) {
            return JsonNumber(value)
        } else if (value is Boolean) {
            return JsonBoolean(value)
        } else if (value == null) {
            return JsonNull.NULL
        } else {
            throw Exception("Unknown json type.")
        }
    }

    fun wrapStringValue(value: String): JsonValue {
        return when {
            stringIsBoolean(value) -> JsonBoolean(true)
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
        return java.lang.Boolean.TRUE.toString() == value || java.lang.Boolean.FALSE.toString() == value
    }

    private fun stringIsNull(value: String?): Boolean {
        return value.isNullOrEmpty() || value == "null"
    }
}