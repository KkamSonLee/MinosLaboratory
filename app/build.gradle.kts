plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.angdroid.minoslaboratory"
    compileSdk = DefaultConfig.COMPILE_SDK
    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        minSdk = DefaultConfig.MIN_SDK
        targetSdk = DefaultConfig.TARGET_SDK
        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME
        testInstrumentationRunner = DefaultConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = DefaultConfig.JVM_TARGET
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    addAndroidXDependencies()
    addNetworkDependencies()
    implementation(KotlinDependencies.annotation)
    implementation(KotlinDependencies.kotlinxSerialization)
    implementation(KotlinDependencies.kotlin)
    implementation(KotlinDependencies.coroutines)
    implementation(ThirdPartyDependencies.KOTLINX_SERIALAZATION_CONVERTER)
    addRoomDependencies()
    addNavigationDependencies()
    addLifecycleDependencies()
    addDaggerHiltDependencies()
    implementation(ThirdPartyDependencies.COIL)
    implementation(ThirdPartyDependencies.TIMBER)
    implementation(AndroidXDependencies.WORK_MANAGER)
}