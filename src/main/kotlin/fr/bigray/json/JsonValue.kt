package fr.bigray.json

interface JsonValue {
    val value: Any?
    fun toJson(): String
}

data class JsonString(override val value: String = "null") : JsonValue {
    override fun toJson(): String {
        return "\"${value.trim()}\""
    }

}

data class JsonNumber(override val value: Number) : JsonValue {
    override fun toJson(): String {
        return this.value.toString()
    }

}

data class JsonNull(override val value: Any? = null) : JsonValue {
    override fun toJson(): String {
        return "null"
    }

    companion object {
        val NULL: JsonNull = JsonNull()
    }

}

data class JsonBoolean(override val value: Boolean) : JsonValue {
    override fun toJson(): String {
        return this.value.toString()
    }

}