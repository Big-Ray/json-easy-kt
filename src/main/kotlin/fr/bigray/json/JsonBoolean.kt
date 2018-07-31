package fr.bigray.json

class JsonBoolean(override val value: Boolean): JsonValue {

    override fun toJson(): String {
        return this.value.toString()
    }

    override fun toString(): String {
        return "JsonBoolean(value=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonBoolean

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}
