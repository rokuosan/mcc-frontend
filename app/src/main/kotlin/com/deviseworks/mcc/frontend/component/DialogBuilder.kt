package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.entity.Player
import mui.material.Button
import mui.material.ButtonColor
import mui.material.ButtonVariant
import mui.material.Dialog
import mui.material.DialogActions
import mui.material.DialogContent
import mui.material.DialogContentText
import mui.material.DialogTitle
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useState

enum class DialogType{
    BAN,
    KICK
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

    div{
        Button{
            variant = ButtonVariant.outlined
            color = when(props.type){
                DialogType.KICK -> {
                    ButtonColor.primary
                }
                DialogType.BAN -> {
                    ButtonColor.error
                }
            }
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
                    // 否定
                    Button{
                        autoFocus = true
                        onClick = { setOpenStatus(false) }
                        + "いいえ"
                    }

                    // 肯定
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
                                    // ここにKICK処理を書く
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