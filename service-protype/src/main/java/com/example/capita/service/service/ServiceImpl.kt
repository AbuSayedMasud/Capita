package com.example.capita.service.service

import com.example.capita.service.CapitaService
import com.example.capita.service.Service
import com.example.service.protype.R
import java.util.Locale

class ServiceImpl : CapitaService {
    private val serviceData = listOf(
        Service(
            icon = R.drawable.cheque,
            title = "New Chequebook",
        ),
        Service(
            icon = R.drawable.stop_cheque,
            title = "Stop Cheque",
        ),
        Service(
            icon = R.drawable.pay,
            title = "Positive Pay",
        ),
        Service(
            icon = R.drawable.certificate,
            title = "Paper Certificate",
        ),
        Service(
            icon = R.drawable.pay_order,
            title = "Pay Order",
        ),
        Service(
            icon = R.drawable.request_log,
            title = "Request Log",
        ),
    )

    override fun serviceSearch(searchText: String): List<Service> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return serviceData.filter { service ->
            (
                service.title.contains(lowerCaseSearchText)
//                            ||
//                            instrument.symbol.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText) ||
//                            instrument.market.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText) ||
//                            instrument.assetClass.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText)
                )
        }
    }

    override fun listService(): List<Service> {
        return serviceData
    }
}
