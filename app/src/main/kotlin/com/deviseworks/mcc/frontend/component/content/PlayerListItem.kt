package com.deviseworks.mcc.frontend.component.content

import com.deviseworks.mcc.frontend.entity.Player
import csstype.*
import mui.material.Box
import mui.material.Button
import mui.material.ButtonColor
import mui.material.ButtonVariant
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


external interface PLayerInfoProps: Props{
    var data: Player
}

val PlayerListItem = FC<PLayerInfoProps> { props ->
    Card{
        sx{
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

            // 名前
            CardContent{
                sx{
                    flex = Flex(number(1.0), number(1.0), Auto.auto)
                }
                Typography{
                    component = ReactHTML.div
                    variant = "h5"
                    + props.data.name
                }
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + props.data.uuid
                }
            }

            Box{
                sx{
                    display = Display.flex
                    alignItems = AlignItems.center
                    justifyContent = JustifyContent.spaceBetween
                    paddingLeft = 2.px
                    paddingBottom = 2.px
                    marginLeft = 5.px
                    marginBottom = 5.px
                }
                Button{
                    variant = ButtonVariant.contained
                    color=ButtonColor.error
                    +"Kick"
                }
                Button{
                    variant = ButtonVariant.outlined
                    color=ButtonColor.error
                    +"Ban"
                }
                Button{
                    variant = ButtonVariant.contained
                    color = ButtonColor.inherit
                    +"Whisper"
                }
                Button{
                    color = ButtonColor.success
                    if(props.data.isAdmin!!){
                        variant= ButtonVariant.contained
                        +"Admin"
                    }else{
                        variant= ButtonVariant.outlined
                        +"Member"
                    }
                }
            }
        }
        CardMedia{
            component = ReactHTML.img
            sx{
                width=151.px
            }
            image="https://cravatar.eu/avatar/${props.data.uuid}/64.png"
        }
    }
}