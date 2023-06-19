package com.example.capita.instrument

//class Instrument(val id: Int, val name: String, val symbol:String, val market: String, val assetClass: String) {
//}
class Instrument( val icon: Int,
                       val longName:String,
                       val shortName: String,
                       val equity: String,
                       val market: String,
                       val value: Double,
                       val closedPrice: Double,
                       val change: Double,
                       val changeIcon: Int)