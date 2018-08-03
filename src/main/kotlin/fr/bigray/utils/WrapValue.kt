package fr.bigray.utils

import fr.bigray.json.*

class WrapValue {
    companion object {
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
    }
}