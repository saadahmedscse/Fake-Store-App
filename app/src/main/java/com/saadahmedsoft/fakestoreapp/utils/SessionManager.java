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

package com.saadahmedsoft.fakestoreapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

public class SessionManager {

    /**
     * Session manager boilerplate class to simplify session manager
     */

    @SuppressLint("StaticFieldLeak")
    private static SessionManager instance = null;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    /**
     * The constructor initializes shared preference and editor
     * @param context is required to initialize shared preference
     */

    private SessionManager(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("CONST_SESSION_MANAGER", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * Static function getInstance returns instance of session manager class
     * @param context is required to pass in constructor
     * @return instance of session manager class
     */

    public static SessionManager getInstance(@NonNull Context context) {
        if (instance == null) {
            instance = new SessionManager(context);
        }
        return instance;
    }

    /**
     * Set number in session
     * @param number is required for setting number in session
     */

    public void setNumber(@NonNull String number) {
        editor.putString("CONST_NUMBER", number).apply();
    }

    /**
     * Set token in session
     * @param token is required for setting token in session
     */

    public void setToken(@NonNull String token) {
        editor.putString("CONST_TOKEN", token).apply();
    }

    /**
     * Set bearer token in session
     * @param token is required for setting bearer token in session
     */

    public void setBearerToken(@NonNull String token) {
        editor.putString("CONST_BEARER_TOKEN", "Bearer " + token).apply();
    }

    /**
     * Set email in session
     * @param email is required for setting email in session
     */

    public void setEmail(@NonNull String email) {
        editor.putString("CONST_EMAIL", email).apply();
    }

    /**
     * Set object in session
     * @param object is required for setting in session
     */

    public void setObject(@NonNull Object object) {
        editor.putString("CONST_OBJECT", new Gson().toJson(object)).apply();
    }

    /**
     * Get number from session
     * @return number in string
     */

    public @Nullable
    String getNumber() {
        return sharedPreferences.getString("CONST_NUMBER", null);
    }

    /**
     * Get token from session
     * @return token in string
     */

    public @Nullable
    String getToken() {
        return sharedPreferences.getString("CONST_TOKEN", null);
    }

    /**
     * Get bearer token from session
     * @return bearer token in string
     */

    public @Nullable
    String getBearerToken() {
        return sharedPreferences.getString("CONST_BEARER_TOKEN", null);
    }

    /**
     * Get email from session
     * @return email in string
     */

    public @Nullable
    String getEmail() {
        return sharedPreferences.getString("CONST_EMAIL", null);
    }

    /**
     * Get object from session
     * @param <T> is required to cast the object
     * @param objectType is required to pass type in gson
     * @return object in T
     */

    @SuppressWarnings("unchecked")
    public @Nullable
    <T> T getObject(Class<?> objectType) {
        return (T) new Gson().fromJson(sharedPreferences.getString("CONST_OBJECT", null), objectType);
    }

    /**
     * The function simply removes the session from shared preference
     */

    public void removeSession() {
        editor.clear();
    }
}
