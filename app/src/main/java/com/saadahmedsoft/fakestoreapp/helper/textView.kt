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
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * @return String from textview
 */

fun TextView.getString() = this.text.toString()

/**
 * Change text color of textView
 * @param context is required to get Color
 * @param color is required to change the color
 */

fun TextView.changeTextColor(context: Context, @ColorRes color: Int) {
    this.setTextColor(ContextCompat.getColor(context, color))
}