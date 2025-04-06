ext {
    minSdkVersion = 14
    targetSdkVersion = 29
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
