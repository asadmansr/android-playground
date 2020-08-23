@file:JvmName("StringUtils")
package com.asadmansr.callingkotlincodefromjava

/**
 * The reason is that Kotlin places these "top-level" or package-level function
 * inside a class whose name is based on the filename. In this case, because
 * the file is named StringUtils.kt, the corresponding class is named
 * StringUtilsKt.
 *
 * Either we could change that name or tell Kotlin to use a different name for
 * package-level methods by using the @file:JvmName annotation.
 *
 * The @JvmName annotation is a powerful tool that influences how Kotlin names classes, properties,
 * and methods in the bytecode it generates for the Java Virtual Machine (JVM).
 */

fun String.toTitleCase(): String {
    if (isNullOrBlank()) {
        return this
    }

    return split(" ").map { word ->
        word.foldIndexed("") { index, working, char ->
            val nextChar = if (index == 0) char.toUpperCase() else char.toLowerCase()
            "$working$nextChar"
        }
    }.reduceIndexed { index, working, word ->
        if (index > 0) "$working $word" else word
    }
}

fun String.nameToLogin(): String {
    if (isNullOrBlank()) {
        return this
    }
    var working = ""
    toCharArray().forEach { char ->
        if (char.isLetterOrDigit()) {
            working += char.toLowerCase()
        } else if (char.isWhitespace() and !working.endsWith(".")) {
            working += "."
        }
    }
    return working
}