dependencies {
    implementation(project(":domain"))

    implementation(libs.bundles.spring.infrastructures)
    implementation(libs.bundles.flyway)

    runtimeOnly(libs.bundles.postgresql)

    testImplementation(libs.bundles.testcontainers)
}
