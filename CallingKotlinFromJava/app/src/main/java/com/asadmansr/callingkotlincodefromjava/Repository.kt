package com.asadmansr.callingkotlincodefromjava

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

/**
 * Kotlin is generating a static instance inside our class, rather than exposing these as static properties and methods. E.g. Can be done by referencing
 * Repository.INSTANCE.getNextGuestId()
 *
 * we can get kotlin to generate static methods and properties by annotating the
 * public properties and methods of the Repository with @JvmStatic
 *
 * The @JvmStatic annotation tells the Kotlin compiler to generate a static
 * version of the annotated member or method.
 */

object Repository {
    /**
     * In kotlin, the only types that can be const are primitives such as int, float and string.
     * BACKUP_PATH is a string, we can get a better performance by using const val rather than a
     * val annotated with @JvmField, while retaining the ability to access the value as a field
     */
    const val BACKUP_PATH = "/backup/user.repo"

    private val _users = mutableListOf<User>()
    private var _nextGuestId = 1000

    @JvmStatic
    val users: List<User>
        get() = _users

    @JvmStatic
    val nextGuestId
        get() = _nextGuestId++

    /**
     * Kotlin supports default values for parameters. For warlow, you don't have to specify
     * a parameter as it will take the default one. However, this does not work when calling
     * the method from java.
     *
     * Default values aren't supported in the java programming language. To fix this, tell
     * Kotlin to generate overloads for our constructor with the help of JvmOverloads.
     * Made the following changes to User -> @JvmOverloads constructor
     */
    init {
        _users.add(User(100, "josh", "Joshua Calvert", listOf("admin", "staff", "sys")))
        _users.add(User(101, "dahybi", "Dahybi Yadev", listOf("staff", "nodes")))
        _users.add(User(102, "sarha", "Sarha Mitcham", listOf("admin", "staff", "sys")))
        _users.add(User(103, "warlow", groups = listOf("staff", "inactive")))
    }

    /**
     * Java has the concept of a checked exception - these are exceptions that could be recovered
     * from such as the user mistyping a file name or the network being unavailable. After a checked
     * exception is caught, the developer could then provide feedback to the user on how to fix the
     * problem. Since checked exception are done at compile time, you declare them in the methods
     * signature.
     *
     * Kotlin does not have checked exception. The solution is to ask Kotlin to add the IOException
     * thats potentially thrown to the signature, so that the bytecode includes it as a checked
     * exception.
     */

    @JvmStatic
    @Throws(IOException::class)
    fun saveAs(path: String?):Boolean {
        val backupPath = path ?: return false

        val outputFile = File(backupPath)
        if (!outputFile.canWrite()) {
            throw FileNotFoundException("Could not write to file: $backupPath")
        }
        // Write data...
        return true
    }

    @JvmStatic
    fun addUser(user: User) {
        // Ensure the user isn't already in the collection.
        val existingUser = users.find { user.id == it.id }
        existingUser?.let { _users.remove(it) }
        // Add the user.
        _users.add(user)
    }
}