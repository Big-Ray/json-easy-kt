package fr.bigray.json

interface KjsonValue {
    val value: Any?
    fun toJson(): String

    fun asKjsonObject(): KjsonObject {
        return this as KjsonObject
    }

    fun asKjsonArray(): KjsonArray {
        return this as KjsonArray
    }
}

data class KjsonString(override val value: String = "null") : KjsonValue {
    override fun toJson(): String {
        return "\"${value.trim()}\""
    }

}

data class KjsonNumber(override val value: Number) : KjsonValue {
    override fun toJson(): String {
        return this.value.toString()
    }

}

data class KjsonNull(override val value: Any? = null) : KjsonValue {
    override fun toJson(): String {
        return "null"
    }

    companion object {
        val NULL: KjsonNull = KjsonNull()
    }

}

data class KjsonBoolean(override val value: Boolean) : KjsonValue {
    override fun toJson(): String {
        return this.value.toString()
    }

}