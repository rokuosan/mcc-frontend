package com.deviseworks.mcc.frontend.component.content

import com.deviseworks.mcc.frontend.common.API
import com.deviseworks.mcc.frontend.entity.Memory
import csstype.*
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import mui.material.Box
import mui.material.Card
import mui.material.CardContent
import mui.material.CircularProgress
import mui.material.CircularProgressColor
import mui.material.CircularProgressVariant
import mui.material.Typography
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.useEffectOnce
import react.useState
import kotlin.math.roundToInt

private val mainScope = MainScope()

// メモリを表示する
suspend fun fetchMemory(): Memory{
    val response = window
        .fetch(API.SERVER_MEMORY)
        .await()
        .text()
        .await()

    return Json.decodeFromString(response)
}

val MemoryCard = FC<Props> {
    var memory: Memory? by useState(null)

    useEffectOnce {
        mainScope.launch {
            val deferred = mainScope.async {
                fetchMemory()
            }

            deferred.await().let{
                memory = Memory(
                    totalMemory = it.totalMemory / 1024,
                    maxMemory =  it.maxMemory / 1024,
                    freeMemory = it.freeMemory / 1024,
                    usedMemory = it.usedMemory / 1024,
                    ratio = it.ratio
                )
            }
        }
    }

    Card{
        sx {
            marginTop = 20.px
            marginLeft = 20.px
            display = Display.flex
            width = 600.px
            justifyContent = JustifyContent.spaceBetween
        }

        Box{
            sx{
                display = Display.flex
                flexDirection = FlexDirection.column
            }

            CardContent{
                sx{
                    flex = Flex(number(1.0), number(1.0), Auto.auto)
                }

                Typography{
                    sx{
                        marginBottom = 10.px
                    }
                    component = ReactHTML.div
                    variant = "h5"
                    + "Memory Inspection"
                }

                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + "Total: ${memory?.totalMemory} MB"
                }
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + "Max: ${memory?.maxMemory} MB"
                }
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + "Used: ${memory?.usedMemory} MB"
                }
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + "Free: ${memory?.freeMemory} MB"
                }
            }
        }

        Box{
            component = ReactHTML.div

            sx{
                flexGrow = number(1.0)
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = AlignItems.center
                flexDirection = FlexDirection.column
            }

            CircularProgress{
                variant = CircularProgressVariant.determinate
                value = memory?.ratio
                size = 100
                color = CircularProgressColor.success
            }

            Typography{
                component = ReactHTML.div
                Color("text.secondary")
                sx{
                    fontSize = FontSize.larger
                    fontWeight = FontWeight.bold
                    fontStyle = FontStyle.italic
                }

                + "${memory?.ratio?.roundToInt()} %"
            }
        }
    }
}