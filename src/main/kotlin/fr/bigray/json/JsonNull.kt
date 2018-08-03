package fr.bigray.json

class JsonNull : JsonValue {

    override val value: Any? = null

    override fun toJson(): String {
        return "null"
    }

    override fun toString(): String {
        return "JsonNull()"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonNull

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }

    companion object {
        var NULL: JsonNull = JsonNull()
    }

}
