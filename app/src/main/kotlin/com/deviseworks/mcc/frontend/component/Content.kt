package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import com.deviseworks.mcc.frontend.component.content.PlayerListItem
import com.deviseworks.mcc.frontend.entity.Player
import csstype.Display
import csstype.FlexWrap
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

        val playerList = mutableListOf(
            Player("mock-uuid-1", "MockUser_001", "MockUser_001", true, "ONLINE"),
            Player("mock-uuid-2", "MockUser_002", "MockUser_002", false, "OFFLINE"),
            Player("mock-uuid-3", "MockUser_003", "MockUser_003", false, "OFFLINE"),
        )

        Box{
            sx{
                display = Display.flex
                flexWrap = FlexWrap.wrap
            }

            for(p in playerList){
                PlayerListItem{
                    data = p
                }
            }
        }
    }
}