package com.example.capita.service

interface CapitaService {
    fun serviceSearch(searchText: String): List<Service>
    fun listService(): List<Service>
}
