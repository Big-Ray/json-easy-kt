package fr.bigray.utils

import fr.bigray.json.*
import java.math.BigDecimal

object WrapValue {
    fun wrap(value: Any?): KjsonValue {
        return when (value) {
            is KjsonValue -> value
            is String -> KjsonString(value)
            is Number -> KjsonNumber(BigDecimal(value.toString()))
            is Boolean -> KjsonBoolean(value)
            null -> KjsonNull.NULL
            else -> throw Exception("Unknown json type.")
        }
    }

    fun wrapStringValue(value: String): KjsonValue {
        return when {
            stringIsBoolean(value) -> KjsonBoolean(value.toBoolean())
            stringIsNull(value) -> KjsonNull()
            stringIsNumber(value) -> KjsonNumber(value.toBigDecimal())
            else -> KjsonString(value)
        }
    }

    private fun stringIsNumber(value: String): Boolean {
        try {
            BigDecimal(value)
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