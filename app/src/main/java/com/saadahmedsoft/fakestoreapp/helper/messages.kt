/*
 * Copyright 2022 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedsoft.kotlinhelper.helper

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.saadahmedsoft.fakestoreapp.R

/**
 * Create snackbar by calling the function easily
 * @param context is required for changing snackbar text color
 * @param view is required to make snackbar
 * @param message is required for the snackbar message
 * @param duration is required for snackbar duration
 */

fun snackBar(context: Context, view: View, message: String, duration: Int) {
    val snackBar = Snackbar.make(view, message, duration)
    snackBar.setAction("Close") {
        snackBar.dismiss()
    }

    val snackBarView = snackBar.view
    val font = ResourcesCompat.getFont(context, R.font.regular)

    snackBarView.setBackgroundResource(R.drawable.bg_dark_grey_5)
    val snackText =
        snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    val snackActionText =
        snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
    snackText.setTextColor(Color.LTGRAY)
    snackText.typeface = font
    snackActionText.typeface = font
    snackActionText.isAllCaps = false
    snackActionText.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
    snackText.setTextColor(ContextCompat.getColor(context, R.color.colorLightGrey))
    snackBar.show()
}

/**
 * Create toast by calling the function easily
 * @param context is required for creating toast
 * @param message is required for the toast message
 * @param duration is required for toast duration
 */

fun toast(context: Context, message: String, duration: Int) {
    Toast.makeText(context, message, duration).show()
}