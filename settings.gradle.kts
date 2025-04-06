pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
        maven { url = uri("https://www.jitpack.io") }
        gradlePluginPortal()

        jcenter()
    }
    plugins {
        kotlin("jvm") version "2.1.0"
    }
}
dependencyResolutionManagement {
    //repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
        maven { url = uri("https://www.jitpack.io") }
        gradlePluginPortal()
//        maven("https://jitpack.io")
        jcenter()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":threader")
//, ":threader"

//include ":wads"
//project(":wads").projectDir = new File("D:\\walhalla\\sdk\\UI\\wads\\")