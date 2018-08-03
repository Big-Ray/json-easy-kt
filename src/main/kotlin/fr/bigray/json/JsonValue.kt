package fr.bigray.json

import java.io.Serializable

interface JsonValue : Serializable {
    val value: Any?
    fun toJson(): String
}