package com.rlibanez.mrbeam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rlibanez.mrbeam.ui.beam.BeamActivity
import com.rlibanez.mrbeam.ui.principal.PrincipalActivity
import com.rlibanez.mrbeam.ui.sections.SectionsActivity
import com.rlibanez.mrbeam.ui.settings.SettingsActivity
import com.rlibanez.mrbeam.ui.splash.SplashActivity
import com.rlibanez.mrbeam.ui.theme.MrBeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MrBeamTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { SplashActivity(navController) }
                    composable("principal") { PrincipalActivity(navController) }
                    composable("beam") { BeamActivity(navController) }
                    composable("sections") { SectionsActivity(navController) }
                    composable("settings") { SettingsActivity(navController) }
                }
            }
        }
    }
}
