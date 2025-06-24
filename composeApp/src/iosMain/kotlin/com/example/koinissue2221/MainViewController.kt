package com.example.koinissue2221

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController {
//    val platformModule = remember { module {  } }
//    App(platformModule = module {  })
    App()
}

