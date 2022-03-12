package com.deviseworks.mcc.frontend.component.content

import com.deviseworks.mcc.frontend.common.API
import com.deviseworks.mcc.frontend.entity.Player
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import react.FC
import react.Props
import react.useEffectOnce
import react.useState

val PlayerListTab = FC<Props> {
    var playerList: List<Player> by useState(emptyList())

    useEffectOnce {
        mainScope.launch {
            playerList = fetchPlayerList()
        }
    }

    playerList.forEachIndexed{ _, p ->
        PlayerListItem{
            data = p
        }
    }
}

private val mainScope = MainScope()

suspend fun fetchPlayerList(): List<Player>{
    val response = window
        .fetch(
            API.PLAYER_LIST+"?offline=true"
        )
        .await()
        .text()
        .await()

    return Json.decodeFromString(ListSerializer(Player.serializer()), response)

//    var res: HttpResponse? = null
//
//    coroutineScope {
//        launch{
//            val job = launch{
//                res = client.get(API.PLAYER_LIST){
//                    headers{
//                        append("Access-Control-Allow-Origin", "*")
//                    }
//                    parameter("offline", "true")
//                }
//            }
//            job.join()
//        }
//    }
//
//    val json: String = res!!.receive()
//
//    return Json.decodeFromString(ListSerializer(Player.serializer()), json)
}