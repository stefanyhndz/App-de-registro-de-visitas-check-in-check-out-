
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.2.0"
        id("org.jetbrains.kotlin.android") version "1.9.0"
        id("org.jetbrains.kotlin.jvm") version "1.9.0"
        id("org.jetbrains.kotlin.kapt") version "1.9.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VisitApp"
include(":app")
