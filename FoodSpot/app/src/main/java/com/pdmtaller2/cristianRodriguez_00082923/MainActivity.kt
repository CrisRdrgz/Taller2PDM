package com.pdmtaller2.cristianRodriguez_00082923

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pdmtaller2.cristianRodriguez_00082923.ui.layout.AppLayout
import com.pdmtaller2.cristianRodriguez_00082923.ui.theme.FoodSpotTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodSpotTheme {
                AppLayout()
            }
        }
    }
}



