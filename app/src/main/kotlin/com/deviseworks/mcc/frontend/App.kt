package com.deviseworks.mcc.frontend

import kotlinx.browser.document
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML.h1
import react.dom.render

fun main(){
    render(
        element = App.create(),
        container = document.getElementById("root")!!
    )
}

private val App = FC<Props>{
    h1{
        +"Hello World"
    }
}