// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(PluginSpecScope.application) version "7.3.0" apply false
    id(PluginSpecScope.library) version "7.3.0" apply false
    id(PluginSpecScope.android) version "1.7.10" apply false
    id(PluginSpecScope.hilt) version "2.44" apply false
    id(PluginSpecScope.navigationSafeargs) version "2.4.2" apply false
}
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.hiltGradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
