package com.deviseworks.mcc.frontend.component.content

import com.deviseworks.mcc.frontend.common.PlayerConnection
import com.deviseworks.mcc.frontend.component.DialogBuilder
import com.deviseworks.mcc.frontend.component.DialogTemplate
import com.deviseworks.mcc.frontend.component.DialogType
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

            // 名前とUUID
            CardContent{
                // Style
                sx{
                    flex = Flex(number(1.0), number(1.0), Auto.auto)
                }

                // Name
                Typography{
                    component = ReactHTML.div
                    variant = "h5"
                    + props.data.name
                }
                // DisplayName
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    +(if (props.data.displayName.isNullOrBlank()) "" else props.data.displayName)!!
                }
                // UUID
                Typography{
                    component = ReactHTML.div
                    variant = "subtitle1"
                    Color("text.secondary")
                    + props.data.uuid
                }
            }

            // Controller
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

                // Kick
                DialogBuilder{
                    buttonText = "Kick"
                    template = DialogTemplate("警告", "このプレイヤーを本当にキックしますか？")
                    type = DialogType.KICK
                    player = props.data
                }

                // Ban
                DialogBuilder{
                    buttonText = "Ban"
                    template = DialogTemplate("警告", "このプレイヤーを本当にBANしますか？")
                    type = DialogType.BAN
                    player = props.data
                }

                // Administrator
                DialogBuilder{
                    val message = if(props.data.isAdmin!!){
                        "本当にOP権限を剥奪しますか？"
                    }else{
                        "本当にOP権限を付与しますか？大いなる力には大いなる責任を伴います。"
                    }

                    buttonText = if(props.data.isAdmin!!) "ADMIN" else "Member"
                    template = DialogTemplate("警告", message)
                    type = DialogType.OP
                    player = props.data
                }

                // Connection Status
                Button{
                    sx{
                        marginLeft = 20.px
                    }
                    if(props.data.status == PlayerConnection.ONLINE.status){
                        color = ButtonColor.success
                        variant= ButtonVariant.contained
                        +"Online"
                    }else{
                        color = ButtonColor.inherit
                        variant= ButtonVariant.outlined
                        +"Offline"
                    }
                }
            }
        }

        // Minecraft Head
        CardMedia{
            component = ReactHTML.img
            sx{
                width=151.px
            }
            image="https://cravatar.eu/avatar/${props.data.uuid}/64.png"
//            image="https://cravatar.eu/avatar/steve/64.png"
        }
    }
}