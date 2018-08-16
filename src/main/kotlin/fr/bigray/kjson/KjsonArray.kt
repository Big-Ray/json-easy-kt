package fr.bigray.kjson

class KjsonArray private constructor(override val value: List<KjsonValue>) : Iterable<KjsonValue>, KjsonValue {
    override fun iterator(): Iterator<KjsonValue> {
        return this.value.iterator()
    }

    override fun toJson(): String = this.value.joinToString(prefix = "[", postfix = "]", separator = ",") { it.toJson() }

    companion object {
        @JvmStatic
        fun createArray(values: List<KjsonValue>): KjsonArray = KjsonArray(values)

        @JvmStatic
        fun createArray(values: KjsonArray): KjsonArray = KjsonArray(values.toList())

        @JvmStatic
        fun fromJson(json: String): KjsonArray = Kjson.fromJson(json) as KjsonArray
    }

}
