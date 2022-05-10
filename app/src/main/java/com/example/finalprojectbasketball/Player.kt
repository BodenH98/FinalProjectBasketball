package com.example.finalprojectbasketball


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Player(var id : Int, var first_name : String, var last_name: String, var position: String, var height_feet : Int,
                   var height_inches: Int, var teamId : Int, var conference : String, var divison : String, var teamName : String)
    :Parcelable{


}




