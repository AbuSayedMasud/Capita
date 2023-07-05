package com.example.capita.index


interface IndexService {
    fun listIndex(): List<Indices>
    fun indexSearch(searchText: String): List<Indices>
}
