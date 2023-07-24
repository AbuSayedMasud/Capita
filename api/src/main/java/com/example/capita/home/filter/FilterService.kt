package com.example.capita.home.filter

interface FilterService {
    fun listFilter(): List<Filter>
    fun filterSearch(searchText: String): List<Filter>
}
