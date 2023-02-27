
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
//        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
}

dependencies {
    //Lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*aar"))))

    //Core
    implementation ("${Dependencies.coreKtx}:${Versions.coreKtx}")
    implementation ("${Dependencies.appcompat}:${Versions.appcompat}")
    implementation ("${Dependencies.annotation}:${Versions.annotation}")
    implementation ("${Dependencies.androidMaterial}:${Versions.androidMaterial}")

    //Compose
    implementation ("${Dependencies.composeConstraint}:${Versions.composeConstraint}")
    implementation ("${Dependencies.composeUi}:${Versions.compose}")
    implementation ("${Dependencies.composeMaterial}:${Versions.compose}")
    implementation ("${Dependencies.composeUiUtil}:${Versions.compose}")
    implementation ("${Dependencies.composeUiToolPreview}:${Versions.compose}")
    implementation ("${Dependencies.composeUiTool}:${Versions.compose}")
    implementation ("${Dependencies.activityCompose}:${Versions.activityCompose}")
    implementation ("${Dependencies.composeNavigation}:${Versions.composeNavigation}")
    implementation ("${Dependencies.composeFoundation}:${Versions.compose}")

    //Lifecycle
    implementation ("${Dependencies.lifecycle}:${Versions.lifecycle}")

    //Dagger 2
    implementation ("${Dependencies.dagger}:${Versions.dagger}")
    implementation ("${Dependencies.daggerCompiler}:${Versions.dagger}")

    //Testing
    implementation ("${Dependencies.junit}:${Versions.junit}")
    implementation ("${Dependencies.extJunit}:${Versions.extJunit}")
}