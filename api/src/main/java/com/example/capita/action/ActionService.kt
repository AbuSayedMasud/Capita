package com.example.capita.action


interface ActionService {
    fun listAction(): List<Action>
    fun actionSearch(searchText: String): List<Action>
}
