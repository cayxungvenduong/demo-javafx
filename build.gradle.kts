import org.beryx.jlink.data.JPackageData

plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
    id("org.beryx.jlink") version "2.23.1"
}

group = "com.demo.tunghoang"
version = "1.0.0-SNAPSHOT"

project.description = "Demo javaFX with Kotlin"
project.version = "1.0.0"

repositories {
    mavenCentral()
}


javafx {
    version = "15.0.1"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

jlink {

    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "frdp"
    }

    jpackage {
        jpackageHome = "/usr/lib/jvm/java-14-openjdk-amd64"
        installerOptions.addAll(listOf("--description", "Demo", "--copyright", "Copyrigth 2021 TungHoang"))
        installerType = project.properties["installerType"].toString()

        when (installerType) {
            "msi" -> {
                installerOptions.addAll(
                    listOf("--win-per-user-install", "--win-dir-chooser", "--win-menu", "--win-shortcut")
                )
            }

            "deb" -> {
                installerOptions.addAll(
                    listOf(
                        "--linux-deb-maintainer",
                        "tunghoang",
                        "--linux-package-name",
                        "frdp",
                        "--linux-menu-group",
                        "Utility",
                        "--linux-shortcut"
                    )
                )
            }

            "rpm" -> {
                installerOptions.addAll(
                    listOf(
                        "--linux-package-name",
                        "frdp",
                        "--linux-menu-group",
                        "Utility",
                        "--linux-shortcut",
                        "--linux-rpm-license-type",
                        "GPLv3"
                    )
                )
            }
        }

    }
}


open class MyClass : DefaultTask() {
    @org.gradle.api.tasks.TaskAction
    fun greet() {
        val installerType = project.properties["installerType"] as String
        println(installerType)
    }
}

tasks.register<MyClass>("hello")


dependencies {
    implementation(kotlin("stdlib"))
//    testCompile("junit", "junit", "4.12")
}

application {
    mainModule.set("frdp")
    mainClass.set("frdp/com.demo.tunghoang.fxrdp.Main")

}

