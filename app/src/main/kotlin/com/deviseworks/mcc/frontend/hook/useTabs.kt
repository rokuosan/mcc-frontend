package com.deviseworks.mcc.frontend.hook

import com.deviseworks.mcc.frontend.component.content.PlayerListTab
import com.deviseworks.mcc.frontend.component.content.ServerInfoTab
import com.deviseworks.mcc.frontend.entity.Tab
import com.deviseworks.mcc.frontend.entity.Tabs
import react.useMemo

fun useTabs(): Tabs{
    return useMemo{
        setOf(
            Tab("player", "プレイヤー", PlayerListTab),
            Tab("server", "サーバー", ServerInfoTab)
        )
    }
}