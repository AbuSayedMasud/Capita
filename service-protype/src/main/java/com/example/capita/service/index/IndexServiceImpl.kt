package com.example.capita.service.index

import com.example.capita.index.IndexService
import com.example.capita.index.Indices
import com.example.service.protype.R
import java.util.Locale

class IndexServiceImpl : IndexService {

    val index = listOf(
        Indices(
            icon = R.drawable.logo1,
            shortName = "DSEX",
            longName = "DSEX Index",
            amount = 6331.36305,
            increase = 1.93465,
            percentage = 0.18815,
            changeIcon = R.drawable.minus
        ),
        Indices(
            icon = R.drawable.logo1,
            shortName = "DSES",
            longName = "DSES Index",
            amount = 1373.82707,
            increase = 2.46399,
            percentage = 0.17903,
            changeIcon = R.drawable.minus
        ),
        Indices(
            icon = R.drawable.logo1,
            shortName = "DS30",
            longName = "DS30 Index",
            amount = 2191.51864,
            increase = 0.42042,
            percentage = -0.01918,
            changeIcon = R.drawable.minus
        )
    )

    override fun listIndex(): List<Indices> {
        return index
    }


}