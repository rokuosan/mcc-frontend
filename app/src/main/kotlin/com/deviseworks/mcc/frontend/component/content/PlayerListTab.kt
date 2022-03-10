package com.deviseworks.mcc.frontend.component.content

import com.deviseworks.mcc.frontend.entity.Player
import csstype.Display
import csstype.FlexWrap
import mui.material.Box
import mui.system.sx
import react.FC
import react.Props

val PlayerListTab = FC<Props> {
    val playerList = mutableListOf<Player>()

    for(i in 1..100){
        playerList.add(Player("MockUUID_$i", "MockUser_$i", "MockUser_$i", false, "ONLINE"))
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