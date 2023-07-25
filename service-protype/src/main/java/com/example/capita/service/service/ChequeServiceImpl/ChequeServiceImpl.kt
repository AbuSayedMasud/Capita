package com.example.capita.service.service.ChequeServiceImpl

import com.example.capita.service.Service
import com.example.capita.service.chequebook.Cheque
import com.example.capita.service.chequebook.ChequeService

class ChequeServiceImpl : ChequeService {
    private val chequeList = listOf(
        Cheque(
            account1 = "11020000083281 Gulshan Corporate Branch",
            branch1 = "Gulshan Branch",
            definition1 = "Saving Bank Account Cheque, Leaf No: 10",
        ),
        Cheque(
            account1 = "11020002367456 Mirpur Corporate Branch",
            branch1 = "Mirpur Branch",
            definition1 = "Current Bank Account Cheque, Leaf No: 18",
        ),
    )

    override fun listChequeService(): List<Cheque> {
        return chequeList
    }
}
