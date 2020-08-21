package com.asadmansr.convertingtokotlin

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

    /**
     * The private _users property becomes the backing property for the public
     * users property. Outside the repository class, the _users list is not
     * modifiable, as consumers of the class can access the list only through
     * users.
     */
    private val _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

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
     *
     * commented due to extension
     */
//    val formattedUserNames: List<String>
//        get() {
//            return _users.map { user ->
//                if (user.lastName != null) {
//                    if (user.firstName != null) {
//                        "${user.firstName} ${user.lastName}"
//                    } else {
//                        user.lastName ?: "Unknown"
//                    }
//                } else {
//                    user.firstName ?: "Unknown"
//                }
//            }
//        }
    val formattedUserNames: List<String>
        get() {
            return _users.map { user -> user.userFormattedName }
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

        _users.apply {
            add(user1)
            add(user2)
            add(user3)
        }
    }

    /**
     * To execute code only in the context of a specific object, without needing to
     * access the object based on its name. Kotlin offers 5 scope function:
     * let, apply, with, run and also.
     * These functions make your code easier to read and more concise. All scope
     * functions have a receiver (this), may have an argument (it) and may return
     * a value.
     *
     * top-level initialization -> run
     * null-check -> T?.let
     * Chaining operations -> object configuration -> T.apply
     * Chaining operations -> side-effect -> T.also
     * Chaining operations -> map -> T.let
     */
}

/**
 * In kotlin, you can declare top-level functions without having a class. It also
 * provides the ability to create extension functions. These are functions that
 * extend a certain type but are declared outside of the type.
 *
 * To extend the functionality of a class, either because we don't own the class
 * or because it's not open to inheritance, Kotlin created special declarations
 * called extensions.
 */

// extension function
fun User.getFormattedName(): String {
    return if (lastName != null) {
        if (firstName != null) {
            "$firstName $lastName"
        } else {
            lastName ?: "Unknown"
        }
    } else {
        firstName ?: "Unknown"
    }
}

// extension property
val User.userFormattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "Unknown"
            }
        } else {
            firstName ?: "Unknown"
        }
    }

// usage:
val user = User("Joe", "hi")
val name = user.getFormattedName()
val formattedName = user.userFormattedName
