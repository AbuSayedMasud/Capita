import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.portfolio.ledger.Ledger

@Composable
fun ledgerView(ledger: Ledger) {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp),
        elevation = 2.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                val plusSign = "+ "
                val minusSign= "-"
                val amount = ledger.totalAmount.toString()
                Text(
                    text = ledger.transferType,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.Start,
                )
                if(ledger.identity=="credit"){
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color =Color(0xFF006A4E), // Set the color you want for the plus sign
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(plusSign)
                            }
                            append(amount)
                        },
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2f),
                        textAlign = TextAlign.End,
                    )
                }
                else{
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red, // Set the color you want for the plus sign
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(minusSign)
                            }
                            append(amount)
                        },
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2f),
                        textAlign = TextAlign.End,
                    )
                }
//                Text(
//                    text = ledger.totalAmount.toString(),
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.weight(1f),
//                    textAlign = TextAlign.End,
//                )
            }

            // Check if description is not empty to show the second row
            if (ledger.description.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Log.d("ledger","asdbfsd")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = ledger.description,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        modifier = Modifier.weight(2f),
                        textAlign = TextAlign.Start,
                    )

                    Text(
                        text = ledger.quantity,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End,
                    )
                }
            } else {
                // If description is empty, dynamically adjust the height of the row to 0

                Spacer(modifier = Modifier.height(0.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = ledger.date,
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
