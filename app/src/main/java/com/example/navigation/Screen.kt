package com.example.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object DetailScreen : Screen ("detail_screen")

    fun withArgs(vararg arg:String):String{
        return  buildString {
            append(route)
            arg.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
