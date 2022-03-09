package com.deviseworks.mcc.frontend.entity

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Player(
    // UUID
    @SerialName("uuid")
    val uuid: String = "",

    // プレイヤー名
    @SerialName("name")
    var name: String = "",

    // 表示名
    @SerialName("display_name")
    var displayName: String? = null,

    // 管理者フラグ
    @SerialName("admin_flag")
    var isAdmin: Boolean? = null,

    // 接続状況
    @SerialName("status")
    var status: String? = null
)