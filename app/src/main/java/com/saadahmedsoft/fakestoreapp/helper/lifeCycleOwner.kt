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

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * This functions are created to simplify the livedata observer
 * @param liveData is required for observing
 * @param action is required to handle the action
 */

inline fun <T> LifecycleOwner.observe(
    liveData: MutableLiveData<T>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(this) { it?.let(action) }
}

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline action: (T) -> Unit) {
    liveData.observe(this) { it?.let(action) }
}