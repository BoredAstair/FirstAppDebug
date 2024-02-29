package chatvalier.nfg.firstappdebug

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(activity:Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Lay1"){
        composable(route = "Lay1"){
            LayOne(navController,activity)
        }
        composable(route = "Lay2"){
            LayTwo(navController)
        }
        composable(route = "Lay3/{x}",
            arguments = listOf(
                navArgument(name="x"){
                    type = NavType.StringType
                }
            )){
                backstackEntry ->
            backstackEntry.arguments?.getString("x")?.let {
                LayThree(navController,
                    msg = it
                )
            }
            }
    }
}