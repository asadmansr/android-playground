package com.asadmansr.convertingtokotlin

/**
 * Pro tip: In Kotlin, we recommend using immutable objects whenever possible
 * (i.e. val instead of var) and avoiding nullable types. You should strive
 * to make nullability meaningful and something you want to handle specifically.
 */

/**
 * User class only holds data. By marking this class as a data class, the compiler
 * will automatically create getters and setters for us. It will also derive the
 * equals(), hashCode() and toString() function.
 */

/**
 * Can create an instance by:
 * val user1 = User("Jane", "Doe")
 *
 * Kotlin has two equality:
 * - structural equality == which determines if two instances are equal
 * - referential equality === checks if two references point to the same object
 *
 * val user1 = User("Jane", "Doe")
 * val user2 = User("Jane", "Doe")
 * val structurallyEqual = user1 == user2 // true
 * val referentiallyEqual = user1 === user2 // false
 */

data class User(var firstName: String?, var lastName: String?)

/**
 * In kotlin we can define default values in function calls. Constructors are also
 * functions.
 *
 * data class User(var firstName: String?, var lastName: String? = null)
 *
 * // usage
 * val jane = User("Jane") // same as User("Jane", null)
 * val joe = User("Joe", "Doe")
 *
 * You can also call a function through a named argument:
 * val jane = User(firstName = "Jane")
 */