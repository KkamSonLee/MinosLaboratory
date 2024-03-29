// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath(Plugins.HILT_PLUGIN)
        classpath(Plugins.SAFE_ARGS_PLUGIN)
    }
}
plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0" apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}