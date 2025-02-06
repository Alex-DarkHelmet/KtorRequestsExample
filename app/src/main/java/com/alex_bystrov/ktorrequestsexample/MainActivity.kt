package com.alex_bystrov.ktorrequestsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.CharacterListScreen
import com.alex_bystrov.ktorrequestsexample.ui.theme.KtorRequestsExampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorRequestsExampleTheme(
                darkTheme = true
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Rick & Morty characters") },
                        )
                    }
                ) { innerPadding ->
                    CharacterListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
