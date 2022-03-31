package com.example.championsleague.presentation.base

interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()

}