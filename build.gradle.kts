import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ru.endlesscode.bukkitgradle.dependencies.spigotApi

plugins {
    kotlin("jvm") version "1.6.21"
    id("ru.endlesscode.bukkitgradle") version "0.10.1"
}

group = "com.craftschemers"
description = "MC-Zone plugin"
version = "0.1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    compileOnly(spigotApi)

    testImplementation("com.github.seeseemelk:MockBukkit-v1.18:2.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

bukkit {
    apiVersion = "1.18.2"
    meta {
        name.set("McZone")
        description.set("McZone plugin")
        main.set("com.craftschemers.mczone.McZonePlugin")
    }
    server {
        coreType = ru.endlesscode.bukkitgradle.server.extension.CoreType.PAPER
        eula = true
        onlineMode = false
        debug = true
        encoding = "UTF-8"
        javaArgs("-Xmx1G")
        bukkitArgs("nogui")
    }
}
