package com.example.capita.service.portfolio.ledger

import com.example.capita.portfolio.ledger.Ledger
import com.example.capita.portfolio.ledger.LedgerService

class LedgerServiceImpl: LedgerService {
    val ledger= listOf(
        Ledger(
            transferType = "Cash Receive",
            totalAmount = 20000.00,
            description = "",
            quantity = "",
            date = "15-jun-2023",
            identity = "debit"
        ),
        Ledger(
            transferType = "cdbl charge Ac opening(own)",
            totalAmount =  500.00 ,
            description = "",
            quantity = "",
            date = "15-jun-2023",
            identity = "credit"
        ),
        Ledger(
            transferType = "BUY",
            totalAmount =  7575.00 ,
            description = "SubAPSCL NonConvertible and Fully Redeemable Couphead",
            quantity = "500( *15) + 75 ",
            date = "24-jun-2023",
            identity = "credit"
        ),
        Ledger(
            transferType = "SELL",
            totalAmount =  747.00,
            description = "Beximco Ltd.",
            quantity = "50( *15 ) - 3",
            date = "26-jun-2023",
            identity = "debit"
        ),
        Ledger(
            transferType = "BEFTN Receive",
            totalAmount =  747.00,
            description = "CASH DEPOSIT 500Post cash deposits7703991234567-01-210601353487E0012017503024027703991234567",
            quantity = "",
            date = "28-jun-2023",
            identity = "debit"
        )
    )
    override fun listLedger(): List<Ledger> {
        return ledger
    }
}