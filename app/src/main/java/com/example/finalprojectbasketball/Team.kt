package com.example.finalprojectbasketball

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (var id : Int, var conference : String, var division : String, var name : String)
    :Parcelable{

    }