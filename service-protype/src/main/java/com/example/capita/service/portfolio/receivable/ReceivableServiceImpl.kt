package com.example.capita.service.portfolio.receivable

import com.example.capita.portfolio.receivable.Receivable
import com.example.capita.portfolio.receivable.ReceivableService

class ReceivableServiceImpl : ReceivableService {
    val receivable = listOf(
        Receivable(
            Name = "Right Share Receivable",
            company1 = "AL-HAJTEX",
            company2 = "AL-HAJTEX",
            shareQuantity1 = 100.00,
            shareQuantity2 = 50.00,
            amount1 = 0.00,
            amount2 = 0.00,
        ),
        Receivable(
            Name = "Cash Dividend Receivable",
            company1 = "ACI",
            company2 = "ACI",
            shareQuantity1 = 0.0,
            shareQuantity2 = 0.0,
            amount1 = 18000.00,
            amount2 = 18000.00,
        ),
        Receivable(
            Name = "Bonus Receivable",
            company1 = "AL-HAJTEX",
            company2 = "AL-HAJTEX",
            shareQuantity1 = 221.5,
            shareQuantity2 = 221.5,
            amount1 = 0.0,
            amount2 = 0.0,
        ),
        Receivable(
            Name = "IPO Receivable",
            company1 = "AL-ARAB BANK",
            company2 = "AL-ARAB BANK",
            shareQuantity1 = 344.0,
            shareQuantity2 = 344.0,
            amount1 = 0.0,
            amount2 = 0.0,
        ),
    )

    override fun listReceivable(): List<Receivable> {
        return receivable
    }
}
