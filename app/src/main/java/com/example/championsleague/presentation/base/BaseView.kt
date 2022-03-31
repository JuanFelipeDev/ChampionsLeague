package com.example.championsleague.presentation.base

import android.content.Context

interface BaseView {

    fun getContext(): Context

    fun showMessage(message: String)
}