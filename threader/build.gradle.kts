plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
    alias(libs.plugins.kotlin.android)
    //kotlin("android") version "2.1.0"
}

val versionCode0 = 1522
val versionName0 = "1.5.2"

android {


    namespace = "com.walhalla.threader"

    compileSdk = 35
    buildToolsVersion = rootProject.extra["buildToolsVersion0"].toString()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
//        versionCode = versionCode0
//        versionName = versionName0
    }

    buildTypes {
        getByName("debug") {
            // Конфигурация для debug
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    //implementation(libs.androidx.core.ktx)
    // implementation(project(":features:ui"))
    // implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // implementation("androidx.appcompat:appcompat:1.2.0-alpha01")
}

//afterEvaluate {
//    println("@@@@ Configuring publishing tasks... @@@@")
//
//    publishing {
//        publications {
//            create<MavenPublication>("release") {
//                groupId = "com.walhalla.threader"
//                artifactId = "threader-android-app"
//                //version = versionName0
//
//                if (project.plugins.hasPlugin("com.android.library")) {
//                    from(components["release"])
//                } else {
//                    from(components["java"])
//                }
//
//                val aarPath = if (buildDir.toString().startsWith("/home/jitpack/build/toasty/build")) {
//                    "$buildDir/toasty-threader.aar"
//                } else {
//                    "$buildDir/outputs/aar/threader-release.aar"
//                }
//                artifact(aarPath)
//
//                pom {
//                    description.set("First release")
//                }
//            }
//        }
//
//        repositories {
//            mavenLocal()
//        }
//    }
//
//    tasks.named("build") {
//        dependsOn(tasks.named("publishToMavenLocal"))
//    }
//
//    tasks.named("publishToMavenLocal") {
//        dependsOn(tasks.named("build"))
//    }
//}