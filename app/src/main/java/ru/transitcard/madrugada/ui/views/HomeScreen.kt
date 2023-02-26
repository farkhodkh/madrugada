package ru.transitcard.madrugada.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onClickListener: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text ="Овновной экран",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )


        Button(onClick = { onClickListener.invoke(Screens.MainScreen.route) }) {
            Text(text ="Click")
        }
    }
}