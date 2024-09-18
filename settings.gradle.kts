plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "auth"

include("boot")
include("presentation")
include("domain")
include("application")
include("infrastructure")
