package chatvalier.nfg.firstappdebug

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
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
fun LayOne(navController: NavHostController,activity:Context,modifier: Modifier = Modifier){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Log In below",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = modifier.height(50.dp))
        EditTextField(navController,activity)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(navController: NavHostController,activity: Context, modifier: Modifier = Modifier){
    var value1Field by remember {
        mutableStateOf("")
    }
    var value2Field by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = value1Field,
        onValueChange = { value1Field = it},
        modifier = modifier,
        label = { Text(text = "Login") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false
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
        value = value2Field,
        onValueChange = { value2Field = it},
        modifier = modifier,
        label = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Password
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
    Button(onClick = { verifId(
        login = value1Field,
        pwd = value2Field,
        activity = activity,
        navController = navController)
    }) {
        Text(text = "Log In", color = MaterialTheme.colorScheme.secondary)
    }
    Spacer(modifier = modifier.height(20.dp))
    Button(onClick = { navController.navigate("Lay2") }
    ) {
        Text(text = "GO TO NB 2", color = MaterialTheme.colorScheme.secondary)
    }
    Button(onClick = { navController.navigate("Lay3") }) {
        Text(text = "GO TO NB 3", color = MaterialTheme.colorScheme.secondary)
    }
}

private fun verifId(login : String, pwd : String,activity: Context,navController: NavHostController){
    if(login == "etudiant"){
        if(pwd == "AzertY"){
            //Toast.makeText( activity , "User Access Granted", Toast.LENGTH_SHORT).show()
            navController.navigate("Lay2")
        } else {
            //Toast.makeText(activity, "Wrong Password, Access Denied", Toast.LENGTH_SHORT).show()
        }
    } else {
        //Toast.makeText(activity, "Wrong Username, Access Denied", Toast.LENGTH_SHORT).show()
    }
}