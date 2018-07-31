package fr.bigray.json

class JsonNumber(override val value: Number) : JsonValue {

    override fun toJson(): String {
        return this.value.toString()
    }

    override fun toString(): String {
        return "JsonNumber(value=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}
