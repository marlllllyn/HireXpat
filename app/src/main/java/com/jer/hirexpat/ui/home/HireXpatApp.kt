package com.jer.hirexpat.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.size.Dimension
import com.jer.hirexpat.R
import com.jer.hirexpat.navigation.NavigationItem
import com.jer.hirexpat.navigation.Screen
import com.jer.hirexpat.ui.detailjob.DetailPage

import com.jer.hirexpat.ui.joblist.HomePage
import com.jer.hirexpat.ui.joblist.JobListPage
import com.jer.hirexpat.ui.joblist.JobViewModel
import com.jer.hirexpat.ui.livingCostVisa.LivingCostPage
import com.jer.hirexpat.ui.notification.NotificationPage
import com.jer.hirexpat.ui.profile.ProfilePage
import com.jer.hirexpat.ui.theme.HireXpatTheme


@Composable
fun HireXpatApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier.background(colorResource(R.color.cream))
//    viewModel: JobViewModel
    ) {
//    val viewModel: JobViewModel = JobViewModel()
    Scaffold(

        bottomBar = {
            BottomBar(navController)
        },
        modifier = Modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Home.route) {
                HomePage()
            }

            composable(Screen.JobList.route) {
                JobListPage(
                    navigateToDetail = { jobId ->
                        navController.navigate(Screen.DetailJob.createRoute(jobId))
                    },
//                    viewModel = viewModel
                )
            }

            composable(Screen.Notif.route) {
                NotificationPage()
            }

            composable(Screen.Profile.route) {
                ProfilePage()
            }

            composable(
                route = Screen.DetailJob.route,
                arguments = listOf(navArgument("jobId") { type = NavType.LongType })
            ) {
                val id = it.arguments?.getLong("jobId") ?: -1L
                DetailPage(
                    jobId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },

                    )



            }


        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_jobList),
                icon = Icons.Default.List,
                screen = Screen.JobList
            ),
            NavigationItem(
              title = stringResource(R.string.menu_notification),
                icon = Icons.Default.Notifications,
                screen = Screen.Notif
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }

}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun hireXpatPreview(){
    HireXpatTheme {
        HireXpatApp(

        )
    }
}