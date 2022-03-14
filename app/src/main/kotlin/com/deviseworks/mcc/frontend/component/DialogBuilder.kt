package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.entity.Player
import csstype.px
import mui.material.Button
import mui.material.ButtonColor
import mui.material.ButtonVariant
import mui.material.Dialog
import mui.material.DialogActions
import mui.material.DialogContent
import mui.material.DialogContentText
import mui.material.DialogTitle
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useState

enum class DialogType{
    BAN,
    KICK,
    OP
}

data class DialogTemplate(
    val title: String,
    val content: String
)

external interface DialogBuilderProps: Props{
    var buttonText: String
    var template: DialogTemplate
    var type: DialogType
    var player: Player?
}

val DialogBuilder = FC<DialogBuilderProps> { props ->
    val (openStatus, setOpenStatus) = useState(false)

    var c:ButtonColor = ButtonColor.primary // ボタン色
    var v:ButtonVariant = ButtonVariant.outlined // ボタン
    var leftMargin = 0.px

    when(props.type){
        DialogType.KICK -> {
            c = ButtonColor.primary
            v = ButtonVariant.outlined
        }
        DialogType.BAN -> {
            c = ButtonColor.error
            v = ButtonVariant.outlined
        }
        DialogType.OP -> {
            c = ButtonColor.success
            v = if(props.player!!.isAdmin!!) ButtonVariant.contained else ButtonVariant.outlined
            leftMargin = 20.px
        }
    }


    div{
        Button{
            sx {
                marginLeft = leftMargin
            }
            variant = v
            color = c
            onClick ={ setOpenStatus(true) }
            + props.buttonText
        }

        Dialog{
            open = openStatus
            onClose = {_, _ -> setOpenStatus(false)}

            DialogTitle{
                +props.template.title
            }
            DialogContent{
                DialogContentText{
                    +props.template.content
                }
                DialogActions{
                    Button{
                        autoFocus = true
                        onClick = { setOpenStatus(false) }
                        + "いいえ"
                    }

                    // 各ボタンと処理を書く
                    when(props.type){
                        DialogType.BAN -> {
                            Button{
                                onClick = {
                                    // ここにBAN処理を書く
                                    setOpenStatus(false)
                                }
                                + "はい"
                            }
                        }
                        DialogType.KICK -> {
                            Button{
                                onClick = {
                                    // ここにBAN処理を書く
                                    setOpenStatus(false)
                                }
                                + "はい"
                            }
                        }
                        DialogType.OP -> {
                            Button{
                                onClick = {
                                    // ここにBAN処理を書く
                                    setOpenStatus(false)
                                }
                                + "はい"
                            }
                        }
                    }
                }
            }
        }
    }
}