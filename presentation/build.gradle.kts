plugins {
    `java-test-fixtures`
    id("com.netflix.dgs.codegen") version "6.2.1"
}

extra["netflixDgsVersion"] = "9.1.0"

dependencies {
    implementation(project(":application"))

    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-security")

    testImplementation("org.springframework.security:spring-security-test")

    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
    testImplementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("netflixDgsVersion")}")
    }
}

tasks.generateJava {
    schemaPaths.add("$projectDir/src/main/resources/graphql-client")
    packageName = "org.springkt.auth.codegen"
    generateClient = true
}
