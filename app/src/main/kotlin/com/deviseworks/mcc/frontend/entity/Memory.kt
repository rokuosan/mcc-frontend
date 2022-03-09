package com.deviseworks.mcc.frontend.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@kotlinx.serialization.Serializable
data class Memory(
    // 合計メモリ
    @SerialName("total_memory")
    val totalMemory: Long = 0,

    // 最大割り当てメモリ
    @SerialName("max_memory")
    val maxMemory: Long = 0,

    // 空きメモリ
    @SerialName("free_memory")
    val freeMemory: Long = 0,

    // 使用中メモリ
    @SerialName("used_memory")
    val usedMemory: Long = 0,

    // 使用率
    @SerialName("ratio")
    val ratio: Double = 0.0
){
    fun parse(body: String): Memory?{
        return Json.decodeFromString(body)
    }
}