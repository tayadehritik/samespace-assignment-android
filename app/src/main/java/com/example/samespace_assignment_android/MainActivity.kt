package com.example.samespace_assignment_android

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.samespace_assignment_android.ui.theme.AppTheme
import com.example.samespace_assignment_android.ui.screens.ForYouScreen
import com.example.samespace_assignment_android.ui.screens.TopTracks


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {

                Scaffold(

                    bottomBar = {
                        NavigationBar(
                            containerColor = Color.Black
                        ) {

                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination?.route

                            NavigationBarItem(
                                icon = { Box(Modifier.width(0.dp))},
                                label = { Text("For You", style = MaterialTheme.typography.labelLarge) },
                                selected = (currentDestination == "ForYouScreen") ,
                                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
                                onClick = {
                                    if(currentDestination!="ForYouScreen")navController.navigate("ForYouScreen")}
                            )
                            NavigationBarItem(
                                icon = {},
                                label = { Text("Top Tracks", style = MaterialTheme.typography.labelLarge) },
                                selected = (currentDestination=="TopTracks"),
                                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
                                onClick = { if(currentDestination!="TopTracks") navController.navigate("TopTracks") }
                            )

                        }
                    }
                ) {

                    NavHost(navController, startDestination = "ForYouScreen", Modifier.padding(it))
                    {
                        composable("ForYouScreen",
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )
                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )
                            }
                        ) { ForYouScreen() }

                        composable("TopTracks",
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )
                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )
                            }
                            ) { TopTracks() }
                    }

                }


                // A surface container using the 'background' color from the theme

                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    ForYouScreen()

                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}