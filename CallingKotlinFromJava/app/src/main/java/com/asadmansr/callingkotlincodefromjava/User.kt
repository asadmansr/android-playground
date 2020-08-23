package com.asadmansr.callingkotlincodefromjava

/**
 * You will notice hasSystemAccess() was renamed to getHasSystemAccess()
 * To fix the problem, we would like to have Kotlin generate a different
 * name for the val property hasSystemAccess. To do this, we can use the
 * @JvmName annotation.
 */

/**
 * In kotlin, properties are normally exposed via getters and setters. This includes val properties.
 * It's possible to change this behavior by using the @JvmField annotation. When this is applied
 * to a property in a class, Kotlin will skip generating getters (and setters for var properties)
 * methods, and the backing field can be accessed directly.
 *
 * Since user is immutable, we would like to expose each of their properties as fields, so we'll
 * annotate each of them.
 */
data class User @JvmOverloads constructor(
    @JvmField val id: Int,
    @JvmField val username: String,
    @JvmField val displayName: String = username.toTitleCase(),
    @JvmField val groups: List<String> = listOf("guest")
) {
    @get:JvmName("hasSystemAccess")
    val hasSystemAccess
        get() = "sys" in groups
}

/**
 * This signals to Kotlin to change the signature of the explicitly-defined getter to the name
 * provided.
 *
 * By using the @JvmName annotation, Kotlin generates bytecode that has the specified name,
 * rather than the default one, for the item being annotated.
 *
 * You can also do it for setters:
 * @set:JvmName("updateRed")
 * var red = 0f
 *
 * color.updateRed(0.8f);
 */