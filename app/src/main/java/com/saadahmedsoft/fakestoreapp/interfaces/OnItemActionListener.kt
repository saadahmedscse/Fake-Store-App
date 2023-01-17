package com.saadahmedsoft.interfaces

import android.view.View

interface OnItemActionListener<T> {
        fun onItemClickListener(view: View, item: T, position: Int)
    }