package edu.jgsilveira.networkdatabase.compose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform