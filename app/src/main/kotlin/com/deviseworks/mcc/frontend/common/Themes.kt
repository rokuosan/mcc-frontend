package com.deviseworks.mcc.frontend.common

import kotlinx.js.jso
import mui.material.styles.createTheme

var fonts = listOf("Noto Sans JP", "Murecho", "sans-serif").toString().drop(1).dropLast(1)

val SampleTheme = createTheme(
    jso{
        typography = jso{ fontFamily = fonts }
    }
)