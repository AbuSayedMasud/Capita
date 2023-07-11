package com.example.capita.home.index


interface IndexService {
    fun listIndex(): List<Indices>
    fun indexSearch(searchText: String): List<Indices>
}
