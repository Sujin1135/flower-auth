import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.plugin)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.dependency.management)
    alias(libs.plugins.graalvm.buildtools)
    alias(libs.plugins.dgs.codegen)
}

allprojects {
    group = "org.springkt"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

group = "org.springkt"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

subprojects {
    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    dependencies {
        implementation(rootProject.libs.spring.boot.webflux)
        implementation(rootProject.libs.jackson.module.kotlin)
        implementation(rootProject.libs.reactor.kotlin.extensions)
        implementation(rootProject.libs.kotlin.reflect)
        implementation(rootProject.libs.kotlinx.coroutines.reactor)
        implementation(rootProject.libs.bundles.arrow.kt)

        developmentOnly(rootProject.libs.spring.boot.devtools)

        testImplementation(rootProject.libs.spring.boot.starter.test)
        testImplementation(rootProject.libs.reactor.test)
        testImplementation(rootProject.libs.junit5)
        testImplementation(rootProject.libs.junit.platform.launcher)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
