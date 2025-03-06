plugins {
    alias(libs.plugins.kotlin.android)
}
apply plugin: 'com.android.application'
//apply from: "${project.rootDir}/QA/quality.gradle"

android {
    compileSdkVersion 35
    buildToolsVersion '35.0.0'

    defaultConfig {
        applicationId "com.kodelabs.boilerplate.example"
        minSdkVersion 15
        targetSdkVersion 35
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    // general
    implementation libs.androidx.appcompat
    implementation libs.material

    implementation(libs.play.services.ads)

    //implementation 'com.google.android.gms:play-services-ads:17.1.1'
    implementation libs.timber
    // network
    implementation 'com.squareup.retrofit2:retrofit:2.11.0'
    implementation libs.core.ktx
    // tests
    testImplementation 'junit:junit:4.12'
    testImplementation 'org.mockito:mockito-core:2.8.9'
    implementation project(':threader')
//    implementation project(':wads')
    debugImplementation 'com.squareup.leakcanary:leakcanary-android:1.6.3'
    releaseImplementation 'com.squareup.leakcanary:leakcanary-android-no-op:1.6.3'
}
