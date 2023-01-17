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

import android.view.View
import androidx.annotation.DrawableRes

/**
 * Simplifies the setOnClickListener function
 * call with view.onClicked() { yourBlock() }
 */

infix fun View.onClicked(onClick: (View) -> Unit) {
    setOnClickListener { onClick(it) }
}

/**
 * Simplifies the setOnLongClickListener function
 * call with view.onLongPressed() { yourBlock() }
 */

infix fun View.onLongPressed(onPress: (View) -> Boolean) {
    setOnLongClickListener { onPress(it) }
}

/**
 * call view.visible() to make view visible
 */

fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * call view.invisible() to make view invisible
 */

fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * call view.gone() to make view gone
 */

fun View.gone() {
    visibility = View.GONE
}

/**
 * call view.enable() to enable a view or button
 */

fun View.enable() {
    this.isEnabled = true
    this.alpha = 1f
}

/**
 * call view.disable() to disable a view or button
 * it also decrease the alpha of the view
 */

fun View.disable() {
    this.isEnabled = false
    this.alpha = 0.4.toFloat()
}

/**
 * call view.changeBackground(drawable) to change the background
 * @param drawable is required to change the background
 */

fun View.changeBackground(@DrawableRes drawable: Int) {
    this.setBackgroundResource(drawable)
}