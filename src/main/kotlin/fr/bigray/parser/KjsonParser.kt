package fr.bigray.parser

import fr.bigray.kjson.*
import fr.bigray.utils.WrapValue.wrapStringValue

object KjsonParser {
    private const val OPEN_BRACE = 123
    private const val CLOSE_BRACE = 125
    private const val OPEN_BRACKET = 91
    private const val CLOSE_BRACKET = 93
    private const val DBL_QUOTE = 34
    private const val COMMA = 44

    fun parse(json: String): KjsonValue? {
        val firstCharacter = json.first().toInt()
        val lastCharacter = json.last().toInt()

        when {
            (OPEN_BRACE == firstCharacter).and(CLOSE_BRACE == lastCharacter) -> {
                val jsonValue = KjsonObjectBuilder()

                split(json)
                        .map { it.trim().split(":".toRegex(), 2).toTypedArray() }
                        .forEach {
                            val key = it[0]
                            val value = it[1]

                            if (isJson(value)) {
                                jsonValue.add(key.trim(), parse(value))
                            } else {
                                jsonValue.add(key.trim(), wrapStringValue(value.trim()))
                            }
                        }

                return jsonValue.create()
            }
            (OPEN_BRACKET == firstCharacter).and(CLOSE_BRACKET == lastCharacter) -> {
                val jsonValue = KjsonArrayBuilder()

                split(json).forEach {
                    if (isJson(it)) {
                        jsonValue.add(parse(it))
                    } else {
                        jsonValue.add(wrapStringValue(it.trim()))
                    }
                }

                return jsonValue.create()
            }
            else -> throw RuntimeException("Is not a valid json!")
        }
    }

    private fun isJson(it: String) = (OPEN_BRACE == it.first().toInt()).and(CLOSE_BRACE == it.last().toInt())
            .or((OPEN_BRACKET == it.first().toInt()).and(CLOSE_BRACKET == it.last().toInt()))

    private fun split(json: String): List<String> {

        val jsonEntryList = mutableListOf<String>()
        val jsonChar = splitToCharList(json)

        jsonChar.removeAt(0)
        jsonChar.removeAt(jsonChar.lastIndex)

        val lastCharacterIdx = jsonChar.lastIndex

        var stringBuilder = StringBuilder()
        var jsValueBuilder = StringBuilder()

        var inJsValue = false

        for (i in jsonChar.indices) {
            when (jsonChar[i].toInt()) {
                OPEN_BRACE -> {
                    jsValueBuilder.append(jsonChar[i])
                    inJsValue = true
                }
                CLOSE_BRACE -> {
                    jsValueBuilder.append(jsonChar[i])
                    stringBuilder.append(jsValueBuilder.toString())

                    if (lastCharacterIdx == i) {
                        jsonEntryList.add(stringBuilder.toString())
                    }

                    jsValueBuilder = StringBuilder()
                    inJsValue = false
                }
                OPEN_BRACKET -> {
                    jsValueBuilder.append(jsonChar[i])
                    inJsValue = true
                }
                CLOSE_BRACKET -> {
                    jsValueBuilder.append(jsonChar[i])
                    stringBuilder.append(jsValueBuilder.toString())

                    if (lastCharacterIdx == i) {
                        jsonEntryList.add(stringBuilder.toString())
                    }

                    jsValueBuilder = StringBuilder()
                    inJsValue = false
                }
                COMMA -> {
                    when {
                        inJsValue -> jsValueBuilder.append(jsonChar[i])
                        else -> {
                            jsonEntryList.add(stringBuilder.toString())
                            stringBuilder = StringBuilder()
                        }
                    }
                }
                DBL_QUOTE -> if (i == lastCharacterIdx) {
                    jsonEntryList.add(stringBuilder.toString())
                }
                else -> when {
                    inJsValue -> jsValueBuilder.append(jsonChar[i])
                    lastCharacterIdx == i -> {
                        stringBuilder.append(jsonChar[i])
                        jsonEntryList.add(stringBuilder.toString())
                    }
                    else -> stringBuilder.append(jsonChar[i])
                }
            }
        }

        return jsonEntryList
    }

    private fun splitToCharList(jsonToSplit: String): MutableList<Char> {
        return jsonToSplit.trim()
                .toCharArray()
                .toMutableList()
    }

}
