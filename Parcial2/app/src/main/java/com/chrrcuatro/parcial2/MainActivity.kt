package com.chrrcuatro.parcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chrrcuatro.parcial2.ui.navigation.AppNavigation
import com.chrrcuatro.parcial2.ui.theme.Parcial2Theme
import com.chrrcuatro.parcial2.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2Theme {
                val viewModel: ProductViewModel = viewModel()
                AppNavigation(viewModel)
            }
        }
    }
}
