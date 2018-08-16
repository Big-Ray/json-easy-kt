package fr.bigray.kjson

import fr.bigray.utils.WrapValue

class KjsonArray private constructor() : ArrayList<KjsonValue>(), KjsonValue {
    override val value: KjsonArray
        get() = this

    override fun toJson(): String = this.joinToString(prefix = "[", postfix = "]", separator = ",") { it.toJson() }

    companion object {
        @JvmStatic
        fun createArray(): KjsonArray = KjsonArray()

        @JvmStatic
        fun fromJson(json: String): KjsonArray = Kjson.fromJson(json) as KjsonArray
    }

    fun el(entry: Any?): KjsonArray {
        this.add(WrapValue.wrap(entry))
        return this
    }

    fun allEl(entries: List<KjsonValue>): KjsonArray {
        this.addAll(entries)
        return this
    }


}
