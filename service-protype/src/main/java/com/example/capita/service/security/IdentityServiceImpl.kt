package com.example.capita.service.security

import com.example.capita.security.IdentityService


class IdentityServiceImpl: IdentityService {
    override fun authenticate(username: String, password: String): Boolean{
        return true;
    }
}