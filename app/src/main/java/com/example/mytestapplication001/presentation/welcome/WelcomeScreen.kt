package com.example.mytestapplication001.presentation.welcome

import android.os.Parcelable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiState(
    val email: String
): Parcelable {

    companion object {
        val INIT = UiState(
            email = ""
        )
    }
}

@Composable
fun rememberUiState(
    initialState: UiState = UiState.INIT
) = rememberSaveable {
    mutableStateOf(initialState)
}

@Composable
fun WelcomeScreenState(

) {
    val state = rememberUiState()

    WelcomeScreen(
        loadData = {

        },
        email = state.value.email,
        updateEmail = {
            state.value = state.value.copy(email = it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    loadData: () -> Unit,
    email: String,
    updateEmail: (text: String) -> Unit
) {

    Button(onClick = loadData) {
        Text("データを取得する")
    }

    TextField(
        value = email,
        onValueChange = updateEmail,
        label = { Text("Email") }
    )
}