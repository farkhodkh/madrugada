
plugins {
    id(Dependencies.androidApplication) version Versions.androidApplication
    kotlin(Dependencies.kotlinAndroid) version Versions.kotlinAndroid
}

android {
    namespace = Dependencies.namespace
    compileSdkVersion = Versions.compileSdkVersion

    defaultConfig {
        applicationId = Dependencies.applicationId
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = Dependencies.testInstrumentationRunner
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }

        getByName("release") {
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //Lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*aar"))))

    //Core
    implementation ("${Dependencies.coreKtx}:${Versions.coreKtx}")
    implementation ("${Dependencies.appcompat}:${Versions.appcompat}")
    implementation ("${Dependencies.androidMaterial}:${Versions.androidMaterial}")
    implementation ("${Dependencies.constraintlayout}:${Versions.constraintlayout}")

    //Dagger 2
    implementation ("${Dependencies.dagger}:${Versions.dagger}")
    implementation ("${Dependencies.daggerCompiler}:${Versions.dagger}")

    //Navigation component
    // Kotlin
    implementation("${Dependencies.androidxNavigation}:${Dependencies.navigationFragment}:${Versions.androidxNavigation}")
    implementation("${Dependencies.androidxNavigation}:${Dependencies.navigationUi}:${Versions.androidxNavigation}")
    // Feature module Support
    implementation("${Dependencies.androidxNavigation}:${Dependencies.navigationDynamic}:${Versions.androidxNavigation}")
    // Testing Navigation
    implementation("${Dependencies.androidxNavigation}:${Dependencies.navigationTesting}:${Versions.androidxNavigation}")
    // Jetpack Compose Integration
    implementation("${Dependencies.androidxNavigation}:${Dependencies.navigationCompose}:${Versions.androidxNavigation}")

    //Testing
    implementation ("${Dependencies.junit}:${Versions.junit}")
    implementation ("${Dependencies.extJunit}:${Versions.extJunit}")
}