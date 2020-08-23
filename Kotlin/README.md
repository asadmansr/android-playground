## Add Kotlin to an existing app - notes

To add kotlin to an existing project, either add an Android template and select Kotlin as source language or add a new Kotlin file and configure the kotlin environment on the IDE

### Source organization
By default, new kotlin files are saved in the src/main/java, which makes it easy to see both Kotlin and java files in one location. If you want to separate your Kotlin files, you can put it under src/main/kotlin instead. If you do this, then you'll need to include it in the sourceSet configuration:

```groovy
android {
    sourceSets {
        main.java.srcDirs += 'src/main/kotlin'
    }   
}
```

### Code conversion and nullability
In Android, it's common to delay initialization of View objects and other components until the fragment or activity they are attached to reaches the appropriate lifecycle state. The generated Kotlin code treats Button as a nullable type and uses the non-null assertion operator to unwrap the button when adding a click listener (less ideal than lateinit). Android Studio does not have enough information to make this determination during the conversion process.