package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import com.deviseworks.mcc.frontend.component.content.PlayerListItem
import csstype.px
import mui.material.Box
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML

val Content = FC<Props> {
    Box{
        component = ReactHTML.main
        sx{
            gridArea = Area.Content
            padding = 30.px
        }

        PlayerListItem()
    }
}