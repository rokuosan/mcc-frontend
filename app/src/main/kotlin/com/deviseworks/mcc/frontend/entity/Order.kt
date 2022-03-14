package com.deviseworks.mcc.frontend.entity

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Order(
    // ID
    @SerialName("id")
    val id: Int? = null,

    // 送信主のUUID
    @SerialName("sender_uuid")
    val senderUUID: String? = null,

    // 送信日付
    @SerialName("date")
    val date: String? = null,

    // 送信時刻
    @SerialName("time")
    val time: String? = null,

    // コマンドクエリ
    @SerialName("command")
    val command: String? = null,

    // 完了ステータス
    @SerialName("is_done")
    var isDone: Boolean? = null,

    // キャンセルステータス
    @SerialName("is_canceled")
    var isCanceled: Boolean? = null
)

@kotlinx.serialization.Serializable
data class PreOrder(
    @SerialName("command")
    var command: String? = null,
    @SerialName("sender")
    var sender: String? = null
)

/* 想定データ形式
id,
sender,
date, 形式: yyyy-MM-dd
time, 形式: hh:mm:ss
command,
isDone,
isCanceled
 */