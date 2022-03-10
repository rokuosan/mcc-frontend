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

        val playerList = mutableListOf<Player>()

        for(i in 1..100){
            playerList.add(Player("mock-uuid-$i", "MockUser_$i", "MockUser_$i", false, "ONLINE"))
        }

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