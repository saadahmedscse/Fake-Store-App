package com.saadahmedsoft.base.utils

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Constants {

    object Durations {
        const val SNACK_SHORT = Snackbar.LENGTH_SHORT
        const val SNACK_LONG = Snackbar.LENGTH_LONG
        const val TOAST_SHORT = Toast.LENGTH_SHORT
        const val TOAST_LONG = Toast.LENGTH_LONG
    }

    object Api {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    object Messages {
        const val UNEXPECTED_ERROR_OCCURRED = "Unexpected Error Occurred"
        const val NO_INTERNET = "No internet available"
    }
}