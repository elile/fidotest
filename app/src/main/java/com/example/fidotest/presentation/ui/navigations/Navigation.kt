package com.example.fidotest.presentation.ui.navigations

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fidotest.presentation.ui.components.TopBar
import com.example.fidotest.presentation.ui.screens.NewsDetailsScreen
import com.example.fidotest.presentation.ui.screens.NewsScreen
import com.example.fidotest.presentation.viewmodels.NewsViewModel
import com.example.fidotest.utils.Constants.allNewsScreenTag
import com.example.fidotest.utils.Constants.newsScreenTag
import org.koin.androidx.compose.koinViewModel


@Composable
fun Navigation(viewModel: NewsViewModel = koinViewModel()) {

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState()

    var title = "News"
    if (backStackState.value?.arguments?.containsKey("id") == true) {
        val id = backStackState.value?.arguments?.getString("id")
        title = "News $id"
    }

    val showBackBtn = backStackState.value?.destination?.route != allNewsScreenTag


    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            TopBar(
                title = title, showBackBtn = showBackBtn
            ) {
                navController.popBackStack()
            }
        }) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = allNewsScreenTag,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = allNewsScreenTag) {
                NewsScreen(viewModel = viewModel) { id ->
                    val route = newsScreenTag.replace(
                        oldValue = "{id}",
                        newValue = id.toString()
                    )
                    navController.navigate(route)
                }
            }
            composable(route = newsScreenTag) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id", "")
                NewsDetailsScreen(viewModel = viewModel, id = id!!.toInt())
            }
        }

    }

}

