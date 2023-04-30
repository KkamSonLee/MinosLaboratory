import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

fun DependencyHandlerScope.implementations(vararg argument: String) {
    argument.forEach { implementation(it) }
}

fun DependencyHandlerScope.addAndroidXDependencies() {
    implementations(
        AndroidXDependencies.CORE_KTX,
        AndroidXDependencies.APPCOMPAT,
        AndroidXDependencies.FRAGMENT,
        AndroidXDependencies.RECYCLERVIEW,
        AndroidXDependencies.ACTIVITY,
        AndroidXDependencies.MATERIAL_DESIGN,
        AndroidXDependencies.CONSTRAINT_LAYOUT,
        AndroidXDependencies.COROUTINE
    )
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.ANDROID_TEST)
    androidTestImplementation(TestDependencies.ESPRESSO)
    implementation(TestDependencies.MOCKITO)
    androidTestImplementation(TestDependencies.MOCKITO_ANDROID_TEST)
    testImplementation(TestDependencies.COROUTINE_TEST)
    androidTestImplementation(TestDependencies.CORE_TESTING)
    testImplementation(TestDependencies.CORE_TESTING)

}

fun DependencyHandlerScope.addNetworkDependencies() {
    implementations(
        ThirdPartyDependencies.OK_HTTP,
        ThirdPartyDependencies.OK_HTTP_BOM,
        ThirdPartyDependencies.OK_HTTP_LOGGING_INTERCEPTER,
        TestDependencies.GSON_CONVERTER,
        ThirdPartyDependencies.RETROFIT
    )
}

fun DependencyHandlerScope.addLifecycleDependencies() {
    implementations(
        AndroidXDependencies.LIFECYCLE_KTS,
        AndroidXDependencies.VIEW_MODEL,
    )
}

fun DependencyHandler.addDaggerHiltDependencies() {
    implementation(ThirdPartyDependencies.HILT)
    kapt(KaptDependencies.HILT_COMPILER)
}

fun DependencyHandlerScope.addRoomDependencies() {
    implementations(
        AndroidXDependencies.ROOM,
        AndroidXDependencies.ROOM_RUNTIME
    )
    kapt(KaptDependencies.ROOM_COMPILER)
}