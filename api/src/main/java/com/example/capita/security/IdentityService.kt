package com.example.capita.security

interface IdentityService {
    fun authenticate(username: String, password: String): Boolean
}