package fr.bigray.kjson

import fr.bigray.utils.WrapValue

class KjsonObjectBuilder {


    private val values = mutableMapOf<String, KjsonValue>()

    fun create(): KjsonObject {
        return KjsonObject.createObject(this.values)
    }

    fun add(key: String, value: Any?): KjsonObjectBuilder {
        this.values[key] = WrapValue.wrap(value)
        return this
    }

    fun add(pair: Pair<String, Any?>): KjsonObjectBuilder {
        this.add(pair.first, WrapValue.wrap(pair.second))
        return this
    }

    fun addAll(kjsonObject: KjsonObject): KjsonObjectBuilder {
        this.values.putAll(kjsonObject.map { it.toPair() })
        return this
    }

    fun addAll(vararg pairs: Pair<String, Any?>): KjsonObjectBuilder {
        this.values.putAll(pairs.map { it.first to WrapValue.wrap(it.second) })
        return this
    }

    fun addAll(map: Map<String, Any?>): KjsonObjectBuilder {
        this.values.putAll(map.entries.map { it.key to WrapValue.wrap(it.value) })
        return this
    }

}