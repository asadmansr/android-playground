package com.asadmansr.convertingtokotlin

import java.util.*

/**
 * Because we need one instance of Repository class, we used the singleton pattern
 * in Java. With Kotlin, you can enforce this pattern at the compiler level by
 * replacing the class keyword with object.
 *
 * class Repository private constructor --> object Repository
 *
 * When using the object class, we just call functions and properties directly:
 * val formattedUserNames = Repository.formattedUserNames
 */

object Repository {
    // immutable reference of a mutable list which is empty, but can add on stuff
    private val users = mutableListOf<User>();
    fun getUsers(): List<User>? {
        return users
    }

    /**
     *  The non-null assertion operator (!!) converts any variable to a non-null
     *  type, so you can access properties or call functions on it. However, an
     *  exception will be thrown if the variable is indeed null. By using !!,
     *  you're risking exceptions being thrown at runtime.
     *
     *  Instead, prefer handling nullability by using one of these methods:
     *  - doing a null check (if (user != null) { ... } )
     *  - Using the elvis operator ?:
     *  - Using some of the Kotlin standard functions
     */

    /**
     * Kotlin supports destructuring of data class. We could loop through user list
     * and work with the elements within that object. E.g. (firstName, lastName) in
     * users.
     */

    /**
     * The elvis operator ?: will return the expression on its left if its not null
     * or the expression on its right hand side, if the left side is null.
     */

    /**
     * Kotlin provides an extensive list of collection transformations that make
     * development faster and safer by expanding the capabilities of Java APIs.
     * One of them is the map function. This function returns a new list containing
     * the results of applying the given transform function to each element.
     */
    val formattedUserNames: List<String>
        get() {
            return users.map {user ->
                if (user.lastName != null) {
                    if (user.firstName != null) {
                        "${user.firstName} ${user.lastName}"
                    } else {
                        user.lastName ?: "Unknown"
                    }
                } else {
                    user.firstName ?: "Unknown"
                }
            }
        }

    /**
     * In java, we use the static keyword for fields or functions to say that they
     * belong to a class but not to an instance of teh class. This is why we created
     * INSTANCE static field in our Repository class. The companion object block
     * is how you would declare static fields and function.
     *
     * Commenting out code below as its no longer needed
     */
//    companion object {
//        private var INSTANCE: Repository? = null
//        val instance: Repository?
//            get() {
//                if (INSTANCE == null) {
//                    synchronized(Repository::class.java) {
//                        if (INSTANCE == null) {
//                            INSTANCE =
//                                Repository()
//                        }
//                    }
//                }
//                return INSTANCE
//            }
//    }

    /**
     * primary constructor cannot contain any code, so code initialization
     * is placed in the init block. Much of the init block handles initialization
     */
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        users.add(user1)
        users.add(user2)
        users.add(user3)
    }
}