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

import android.app.DatePickerDialog
import android.content.Context
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * This is a extension function to show date picker dialog
 * In activity the function can be called just by it's name
 * But in fragment the function only be called with requireContext().getDateFromDialog()
 * @return picked date in string format
 */

fun TextView.getDateFromDialog(context: Context) {
    val months = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    val c = Calendar.getInstance()
    val yea = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val dpd = DatePickerDialog(context, { _, year, monthOfYear, dayOfMonth ->

        val m = months[monthOfYear]
        val d = "$year-$m-$dayOfMonth"
        val date = defaultFormat.parse(d)
        this.text = defaultFormat.format(date!!)

    }, yea, month, day)

    dpd.show()
}