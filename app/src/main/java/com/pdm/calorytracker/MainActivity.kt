package com.pdm.calorytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdm.calorytracker.ui.theme.CaloryTrackerTheme
import com.pdm.core.domain.preferences.Preferences
import com.pdm.calorytracker.navigation.Route
import com.pdm.onboarding_presentation.activity.ActivityScreen
import com.pdm.onboarding_presentation.age.AgeScreen
import com.pdm.onboarding_presentation.gender.GenderScreen
import com.pdm.onboarding_presentation.goal.GoalScreen
import com.pdm.onboarding_presentation.height.HeightScreen
import com.pdm.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.pdm.onboarding_presentation.weight.WeightScreen
import com.pdm.onboarding_presentation.welcome.WelcomeScreen
import com.pdm.tracker_presentation.search.SearchScreen
import com.pdm.tracker_presentation.tracker_overview.TrackerOverviewScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @OptIn(ExperimentalComposeUiApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shouldShowOnBoarding = preferences.loadShouldShowOnboarding()

        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowOnBoarding) Route.WELCOME else Route.TRACKER_OVERVIEW
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen {
                                navController.navigate(Route.GENDER)
                            }
                        }
                        composable(Route.GENDER) {
                            GenderScreen({ navController.navigate(Route.AGE) })
                        }
                        composable(Route.ACTIVITY) {
                            ActivityScreen({ navController.navigate(Route.GOAL) })
                        }
                        composable(Route.GOAL) {
                            GoalScreen({ navController.navigate(Route.NUTRIENT_GOAL) })
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                { navController.navigate(Route.TRACKER_OVERVIEW) }
                            )
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                { navController.navigate(Route.HEIGHT) })
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                { navController.navigate(Route.WEIGHT) }
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                { navController.navigate(Route.ACTIVITY) }
                            )
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(onNavigate = { mealName, day, month, year ->
                                navController.navigate(Route.SEARCH + "/$mealName/$day/$month/$year")
                            })
                        }
                        composable(
                            route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                            arguments = listOf(
                                navArgument("mealName") {
                                    type = NavType.StringType
                                },
                                navArgument("dayOfMonth") {
                                    type = NavType.IntType
                                },
                                navArgument("month") {
                                    type = NavType.IntType
                                },
                                navArgument("year") {
                                    type = NavType.IntType
                                },
                            )
                        ) {
                            val mealName = it.arguments?.getString("mealName")!!
                            val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                            val month = it.arguments?.getInt("month")!!
                            val year = it.arguments?.getInt("year")!!
                            SearchScreen(
                                scaffoldState = scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
