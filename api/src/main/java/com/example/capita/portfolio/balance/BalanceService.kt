package com.example.capita.portfolio.balance

interface BalanceService {
    fun balanceSearch(searchText: String): List<Balance>
    fun listBalance(): List<Balance>
}
