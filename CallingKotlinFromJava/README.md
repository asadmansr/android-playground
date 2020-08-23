## Calling Kotlin Code from Java

Annotations to change the way Kotlin generates its JVM bytecode, such as
- @JvmStatic - generate static members and methods
- @JvmOverloads - generate overloaded methods for function that have default values
- @JvmName - change the name of getters and setters
- @JvmField - expose a property directly as a field, rather than via getters and setters
- @Throws - declare checked exceptions

### Kotlin-Java interop guide

#### Java (for Kotlin consumption)
- Don't use Kotlin's hard keywords (as, class, break, fun) as the names of methods or fields. These require the use of backticks to escape when calling from Kotlin.
- Avoid Any extension names
- Every non-primitive parameter, return and field type should have nullability annotation.
- Operator overloading

#### Kotin (for Java consumption)
-  File name: always annotate it with @file:JvmName("Foo"). By default, MyClass.kt will be MyClassKt which is unappealing 
- Avoid Nothing generic
- Document exceptions with @Throws.
- Companion function must be annotated with @JvmStatic

#### Enable lint checks
```groovy
android {
    lintOptions {
        enable 'Interoperability'
    }
}
```