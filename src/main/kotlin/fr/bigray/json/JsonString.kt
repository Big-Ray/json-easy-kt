package fr.bigray.json

class JsonString(override val value: String = "null"): JsonValue {

    override fun toJson(): String {
        return "\"${value.trim()}\""
    }

    override fun toString(): String {
        return "JsonString(value='${value.trim()}')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonString

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}
