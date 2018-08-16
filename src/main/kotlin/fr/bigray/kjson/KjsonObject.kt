package fr.bigray.kjson

class KjsonObject private constructor(override val value: Map<String, KjsonValue>) : Iterable<Map.Entry<String, KjsonValue>>, KjsonValue {

    override fun iterator(): Iterator<Map.Entry<String, KjsonValue>> {
        return this.value.iterator()
    }

    override fun toJson(): String = this.value.entries.joinToString(prefix = "{", postfix = "}", separator = ",")
    { "\"${it.key}\":${it.value.toJson()}" }

    companion object {
        @JvmStatic
        fun createObject(vararg values: Pair<String, KjsonValue>): KjsonObject = KjsonObject(values.toMap())

        @JvmStatic
        fun createObject(values: Map<String, KjsonValue>): KjsonObject = KjsonObject(values)

        @JvmStatic
        fun createObject(values: KjsonObject): KjsonObject = KjsonObject(values.associate { it.toPair() })

        @JvmStatic
        fun fromJson(json: String): KjsonObject = Kjson.fromJson(json) as KjsonObject
    }

    fun get(key: String): KjsonValue? {
        return this.value[key]
    }

}
