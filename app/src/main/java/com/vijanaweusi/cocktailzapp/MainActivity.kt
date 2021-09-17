package com.vijanaweusi.cocktailzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.vijanaweusi.cocktailzapp.ui.cocktails.CockTailsCategoriesScreen
import com.vijanaweusi.cocktailzapp.ui.details.CockTailDetailsScreen
import com.vijanaweusi.cocktailzapp.ui.theme.CockTailzAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CockTailzAppTheme {
                Drinkz()
            }
        }
    }
}


@Composable
fun Drinkz() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_drink_list") {
        composable(route = "destination_drink_list") {
            CockTailsCategoriesScreen() { navigationDrinkId ->
                navController.navigate("destination_drink_list/$navigationDrinkId")

            }
        }

        composable(
            route = "destination_drink_list/{drink_category_id}",
            arguments = listOf(navArgument("drink_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: CockTailsDetailsViewModel = viewModel()
            CockTailDetailsScreen(viewModel.mealState.value)
        }

    }

}