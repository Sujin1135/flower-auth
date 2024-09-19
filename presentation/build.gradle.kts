plugins {
    `java-test-fixtures`
    id("com.netflix.dgs.codegen") version "6.2.1"
}

extra["netflixDgsVersion"] = "9.1.0"

dependencies {
    implementation(project(":application"))

    implementation(libs.bundles.spring.boot.auth)
    implementation(libs.dgs.graphql)

    testImplementation(libs.spring.security.test)
    testImplementation(libs.dgs.graphql.test)
}

tasks.generateJava {
    schemaPaths.add("$projectDir/src/main/resources/graphql-client")
    packageName = "org.springkt.auth.codegen"
    generateClient = true
}
