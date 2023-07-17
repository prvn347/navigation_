package com.example.navigation

import android.icu.text.AlphabeticIndex.Bucket.LabelType
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.navigation.Screen.DetailScreen.route

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = Screen.MainScreen.route){
  composable(route = Screen.MainScreen.route){
      MainScreen(navcontroller = navController)
      
  }
        composable(route= Screen.DetailScreen.route + "/{name}", arguments = listOf(navArgument("name"){
            type = NavType.StringType
            defaultValue = "Pravin"
            nullable = true
        })){entry ->
DetailScreen(

    name = entry.arguments?.getString("name") )

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navcontroller:NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier
        .padding(50.dp)
        .fillMaxSize()) {
        TextField(value = text, onValueChange ={
            text = it
        }, )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
                         navcontroller.navigate(Screen.DetailScreen.withArgs(text))

            },
            modifier = Modifier.align(Alignment.End)) {
            Text(text = "To Details")

            }



    }
    
}

@Composable
fun DetailScreen(name:String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text( text = "$name,you are awesome❤")
    }

}

@Preview
@Composable
fun SimpleComposablePreview() {
    Navigation()
}
