subprojects {
    dependencies {
        implementation(project(":presentation"))
        implementation(project(":domain"))
        implementation(project(":infrastructure"))
        implementation(project(":application"))
    }
}
