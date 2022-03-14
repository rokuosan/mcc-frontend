package com.deviseworks.mcc.frontend.component.content

import csstype.Display
import csstype.FlexWrap
import mui.material.Box
import mui.system.sx
import react.FC
import react.Props

val ServerInfoTab = FC<Props> {
    Box{
        sx{
            display = Display.flex
            flexWrap = FlexWrap.wrap
        }

        MemoryCard()
    }
}