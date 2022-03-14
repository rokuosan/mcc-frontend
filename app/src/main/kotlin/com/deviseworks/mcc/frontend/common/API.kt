package com.deviseworks.mcc.frontend.common

object API {
    private const val API_BASE = "http://172.27.1.231:8080"
    const val PLAYER_LIST = "$API_BASE/api/player/list"
    const val SERVER_COMMAND = "$API_BASE/api/server/order/add"
}