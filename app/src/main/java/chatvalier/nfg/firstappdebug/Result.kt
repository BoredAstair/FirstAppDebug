package chatvalier.nfg.firstappdebug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LayThree(navController: NavHostController,msg:String,modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Resultat TTC")
        Spacer(modifier = modifier.height(50.dp))
        Text(
            text = msg,
            modifier = modifier
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("Lay2")
        }) {
            Text(text = "Return to Facture Menu", color = MaterialTheme.colorScheme.secondary)
        }
    }
}

