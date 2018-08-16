package fr.bigray.kjson

import fr.bigray.utils.WrapValue


class KjsonArrayBuilder {

    private val values = mutableListOf<KjsonValue>()

    fun create(): KjsonArray {
        return KjsonArray.createArray(this.values)
    }

    fun add(element: Any?): KjsonArrayBuilder {
        this.values.add(WrapValue.wrap(element))
        return this
    }

    fun addAll(elements: List<Any?>): KjsonArrayBuilder {
        this.values.addAll(elements.map { WrapValue.wrap(it) })
        return this
    }

    fun addAll(kjsonArray: KjsonArray): KjsonArrayBuilder {
        this.values.addAll(kjsonArray.toList())
        return this
    }

}