package com.example.capita.portfolio.instrument

class Instrument(
    val icon: Int,
    val longName: String,
    val shortName: String,
    val value: Double,
    val closedPrice: Double,
    val change: Double,
    val changeIcon: Int,
    val description: List<Pair<String, String>>
)
