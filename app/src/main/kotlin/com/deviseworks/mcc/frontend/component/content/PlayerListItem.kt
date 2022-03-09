package com.deviseworks.mcc.frontend.component.content

import csstype.*
import mui.material.Box
import mui.material.Card
import mui.material.CardContent
import mui.material.CardMedia
import mui.material.Typography
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML

// プレイヤー情報をまとめるコンポーネント
/*
|----------------------------------|
|顔   |  名前         表示名         |
|    |   接続状況      管理者フラグ   |
|---------------------------------|
 */

val PlayerListItem = FC<Props> {
    Card{
        sx{
            marginTop = 20.px
            marginLeft = 20.px
            display = Display.flex
            width = 400.px
            justifyContent = JustifyContent.spaceBetween
        }

        Box{
            sx{
                display = Display.flex
                flexDirection = FlexDirection.column
            }

            // 名前
            CardContent{
                sx{
                    flex = Flex(number(2.0), number(0.0), Auto.auto)
                    alignSelf = AlignSelf.stretch
                }
                Typography{
                    component = ReactHTML.div
                    variant = "h5"
                    + "名前"
                }
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + "UUID"
                }
            }

            Box{
                sx{
                    display = Display.flex
                    alignItems = AlignItems.center
                    paddingLeft = 1.px
                    paddingBottom = 1.px
                }
            }
        }
        CardMedia{
            component = ReactHTML.img
            sx{
                width=151.px
            }
            image="https://cravatar.eu/avatar/shenziii/64.png"
        }
    }
}