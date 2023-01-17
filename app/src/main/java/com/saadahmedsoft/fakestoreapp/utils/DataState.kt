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

package com.saadahmedsoft.kotlinhelper.utils

/**
 * DataState class to get state of api calls
 * Loading will be executed while loading
 * Success will be executed after success
 * Failed will be executed after failed
 */

sealed class DataState<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : DataState<T>()
    class Success<T>(data: T? = null) : DataState<T>(data = data)
    class Failed<T>(message: String? = null) : DataState<T>(message = message)
}
