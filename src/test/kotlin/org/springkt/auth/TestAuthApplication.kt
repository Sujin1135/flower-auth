package org.springkt.auth

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<AuthApplication>().with(TestcontainersConfiguration::class).run(*args)
}
