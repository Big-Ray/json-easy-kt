package fr.bigray.kjson

import fr.bigray.utils.WrapValue
import java.util.*

class KjsonObject private constructor() : LinkedHashMap<String, KjsonValue>(), KjsonValue {
    override val value: KjsonObject
        get() = this

    override fun toJson(): String = this.entries.joinToString(prefix = "{", postfix = "}", separator = ",")
    { "\"${it.key}\":${it.value.toJson()}" }

    companion object {
        @JvmStatic
        fun createObject(): KjsonObject = KjsonObject()

        @JvmStatic
        fun fromJson(json: String): KjsonObject = Kjson.fromJson(json) as KjsonObject
    }

    fun en(key: String, entry: Any?): KjsonObject {
        this[key] = WrapValue.wrap(entry)
        return this
    }

    fun allEn(values: KjsonObject): KjsonObject {
        this.putAll(values)
        return this
    }

}
