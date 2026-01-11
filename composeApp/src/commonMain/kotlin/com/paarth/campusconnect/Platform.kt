package com.paarth.campusconnect

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform