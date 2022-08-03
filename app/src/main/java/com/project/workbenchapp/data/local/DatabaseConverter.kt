package com.project.workbenchapp.data.local

class DatabaseConverter {

    private val separator = ","

    fun convertListToString(list: List<String>) : String {

        val stringBuilder = StringBuilder()
        list.map { string ->
            stringBuilder.append(string).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)

        return stringBuilder.toString()
    }

    fun convertStringToList(string: String) : List<String> {
        return string.split(separator)
    }
}