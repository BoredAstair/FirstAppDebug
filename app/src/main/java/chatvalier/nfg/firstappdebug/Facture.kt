package chatvalier.nfg.firstappdebug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LayTwo(navController: NavHostController, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
    Text(
        modifier = modifier,
        text = "Facture",
        textAlign = TextAlign.Center,
        fontSize = 50.sp
    )
    Spacer(modifier = modifier.height(50.dp))
    FactureTextFields(navController)
    }
}

@Composable
fun FactureTextFields(navController: NavHostController,modifier: Modifier = Modifier){
    var quantity by remember {
        mutableStateOf("0.0")
    }
    var unitPrice by remember {
        mutableStateOf("0.0")
    }
    var totalWithoutTaxes by remember {
        mutableStateOf("0.0")
    }
    var tvaRates by remember {
        mutableStateOf("0.0")
    }
    var discount by remember {
        mutableStateOf("0.0")
    }
    var fidelity by remember {
        mutableStateOf("false")
    }
    var discountEnabled by remember {
        mutableStateOf("false")
    }
    var buttonEnabled by remember {
        mutableStateOf("false")
    }
    OutlinedTextField(
        value = quantity,
        onValueChange = {
            quantity = it
            if(unitPrice.toDouble() != 0.0 && quantity!="" && unitPrice!=""){
                totalWithoutTaxes = (quantity.toDouble() * unitPrice.toDouble()).toString()
            }
            val x = check(totalWithoutTaxes, tvaRates, discount)
            buttonEnabled = if(x){
                "true";
            } else {
                "false"
            }},
        modifier = modifier,
        label = { Text(text = "Quantity") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
        )
    )
    Spacer(modifier = modifier.height(20.dp))
    OutlinedTextField(
        value = unitPrice,
        onValueChange = {unitPrice = it
            if(quantity.toDouble() != 0.0 && unitPrice!="" && quantity!=""){
                totalWithoutTaxes = (quantity.toDouble() * unitPrice.toDouble()).toString()
            }
            val x = check(totalWithoutTaxes, tvaRates, discount)
            buttonEnabled = if(x){
                "true";
            } else {
                "false"
            }
        },
        modifier = modifier,
        label = { Text(text = "Unit Price") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
        )
    )
    Spacer(modifier = modifier.height(20.dp))
    OutlinedTextField(
        value = totalWithoutTaxes,
        onValueChange = {totalWithoutTaxes = it},
        modifier = modifier,
        label = { Text(text = "Total Without Taxes") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
        )
    )
    Spacer(modifier = modifier.height(20.dp))
    OutlinedTextField(
        value = tvaRates,
        onValueChange = {
            tvaRates = it
            val x = check(totalWithoutTaxes, tvaRates, discount)
            buttonEnabled = if(x){
                "true";
            } else {
                "false"
            }},
        modifier = modifier,
        label = { Text(text = "TVA rates") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
        )
    )
    Spacer(modifier = modifier.height(20.dp))
    Text(
        text = "Fidelity ?",
        modifier = modifier
    )
    Switch(
        checked = fidelity.toBooleanStrict(),
        onCheckedChange = {fidelity = it.toString();discountEnabled = fidelity},
        colors = SwitchDefaults.colors(
            checkedTrackColor = MaterialTheme.colorScheme.onPrimary,
            checkedThumbColor = MaterialTheme.colorScheme.secondary,
            checkedBorderColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.onPrimary,
            uncheckedThumbColor = MaterialTheme.colorScheme.primary,
            uncheckedBorderColor = MaterialTheme.colorScheme.primary,

        )
    )
    Spacer(modifier = modifier.height(20.dp))
    OutlinedTextField(
        value = discount,
        onValueChange = {discount = it},
        modifier = modifier,
        enabled = discountEnabled.toBooleanStrict(),
        label = { Text(text = "Discount") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
            disabledIndicatorColor = MaterialTheme.colorScheme.secondary,
            disabledLabelColor = MaterialTheme.colorScheme.secondary,
        )
    )
    Spacer(modifier = modifier.height(50.dp))
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(modifier = modifier.width(20.dp))
        Button(
            enabled = buttonEnabled.toBooleanStrict(),
            onClick = {
                if (discountEnabled.toBooleanStrict()){
                    val total = (totalWithoutTaxes.toDouble() + totalWithoutTaxes.toDouble() * (tvaRates.toDouble()/100)) * (100-discount.toDouble())/100
                    send(total,navController)
                } else {
                    val total = (totalWithoutTaxes.toDouble() + totalWithoutTaxes.toDouble() * (tvaRates.toDouble() / 100))
                    send(total,navController)
                }
            }) {
            Text(text = "Calculer TTC", color = MaterialTheme.colorScheme.secondary)
        }
        Spacer(modifier = modifier.width(20.dp))
        Button(
            onClick = {
                quantity = "0.0"
                unitPrice = "0.0"
                totalWithoutTaxes = "0.0"
                fidelity = "false"
                tvaRates = "0.0"
                discount = "0.0"
                buttonEnabled = "false"
                discountEnabled = "false"
            }) {
            Text(text = "Remise A Zéro", color = MaterialTheme.colorScheme.secondary)
        }
        Spacer(modifier = modifier.width(20.dp))
    }
}

private fun check(x:String, y:String, z:String): Boolean {
    if(x != "" && y != "" && z != ""){
        if(x.toDouble()>0.0 && y.toDouble()>0){
            return(true);
        } else {
            return(false);
        }
    } else {
        return(false);
    }
}

private fun send(x:Double, navController: NavHostController){
    navController.navigate("Lay3/$x")
}