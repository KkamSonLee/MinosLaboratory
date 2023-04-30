object KotlinDependencies {

}

object AndroidXDependencies {
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FragmentKtxVersion}"
    const val ACTIVITY = "androidx.activity:activity-ktx:${Versions.ActivityKtxVersion}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AppCompat}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.RecyclerView}"
    const val ROOM = "androidx.room:room-ktx:${Versions.RoomVersion}"

    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.ConstraintLayoutVersion}"
    const val MATERIAL_DESIGN =
        "com.google.android.material:material:${Versions.MaterialDesignVersion}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.RoomVersion}"
    const val COROUTINE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.CoroutinesAndroidVersion}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NavVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.NavVersion}"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifecycleVersion}"
    const val LIFECYCLE_KTS =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifecycleVersion}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CoreKtxVersion}"
}

object ThirdPartyDependencies {

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RetrofitVersion}"
    const val OK_HTTP_BOM = "com.squareup.okhttp3:okhttp-bom:${Versions.OkHttpVersion}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp"
    const val OK_HTTP_LOGGING_INTERCEPTER =
        "com.squareup.okhttp3:logging-interceptor"
    const val KOTLINX_SERIALAZATION_CONVERTER =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.KotlinxSerializationConverterVersion}"
    const val COIL = "io.coil-kt:coil:${Versions.CoilVersion}"
    const val HILT = "com.google.dagger:hilt-android:${Versions.HiltVersion}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TimberVersion}"
}

object TestDependencies {
    const val JUNIT = "junit:junit:${Versions.JunitVersion}"
    const val ANDROID_TEST = "androidx.test.ext:junit:${Versions.AndroidTestVersion}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.EspressoVersion}"
    const val MOCKITO = "org.mockito:mockito-core:${Versions.MockitoCoreVersion}"
    const val MOCKITO_ANDROID_TEST = "org.mockito:mockito-android:${Versions.MockitoAndroidVersion}"
    const val COROUTINE_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.CoroutineTest}"
    const val CORE_TESTING = "androidx.arch.core:core-testing:${Versions.CoreTesting}"
    const val GSON_CONVERTER =
        "com.squareup.retrofit2:converter-gson:${Versions.GsonConverterVersion}"
}

object KaptDependencies {
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.RoomVersion}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HiltVersion}"
}

object Plugins {
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HiltVersion}"
    const val SAFE_ARGS_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NavVersion}"
}