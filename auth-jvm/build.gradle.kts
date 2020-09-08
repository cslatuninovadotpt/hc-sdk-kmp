/*
 * Copyright (c) 2020 D4L data4life gGmbH / All rights reserved.
 *
 * D4L owns all legal rights, title and interest in and to the Software Development Kit ("SDK"),
 * including any intellectual property rights that subsist in the SDK.
 *
 * The SDK and its documentation may be accessed and used for viewing/review purposes only.
 * Any usage of the SDK for other purposes, including usage for the development of
 * applications/third-party applications shall require the conclusion of a license agreement
 * between you and D4L.
 *
 * If you are interested in licensing the SDK for your own applications/third-party
 * applications and/or if you’d like to contribute to the development of the SDK, please
 * contact D4L by email to help@data4life.care.
 */

plugins {
    id("kotlin-platform-jvm")
    id("java-library")
}

apply(from = "${project.rootDir}/gradle/jacoco.gradle.kts")
apply(from = "${project.rootDir}/gradle/deploy-java.gradle")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    expectedBy(project(":auth-common"))

    implementation(project(":securestore-jvm"))
    implementation(Dependency.Multiplatform.D4L.utilJvm)

    implementation(Dependency.Multiplatform.Kotlin.stdlibJdk8)

    implementation(Dependency.java.scribeCore)
    implementation(Dependency.java.moshi)


    testImplementation(Dependency.Java.Test.junit)
    testImplementation(Dependency.Multiplatform.Test.Kotlin.testJvm)
    testImplementation(Dependency.Multiplatform.Test.Kotlin.testJvmJunit)
    testImplementation(Dependency.Multiplatform.Test.MockK.jdk)
}
