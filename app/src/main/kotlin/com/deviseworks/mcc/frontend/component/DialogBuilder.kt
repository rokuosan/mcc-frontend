package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.API
import com.deviseworks.mcc.frontend.entity.Player
import com.deviseworks.mcc.frontend.entity.PreOrder
import csstype.px
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
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

private val mainScope = MainScope()

private val client = HttpClient(Js){
    install(JsonFeature){
        serializer = KotlinxSerializer()
    }
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
                                    val preOrder = PreOrder(
                                        command = "ban ${props.player?.name}",
                                        sender = "test_user"
                                    )

                                    mainScope.launch {
                                        sendPreOrder(preOrder)
                                    }

                                    setOpenStatus(false)
                                }
                                + "はい"
                            }
                        }
                        DialogType.KICK -> {
                            Button{
                                onClick = {
                                    // ここにKICK処理を書く
                                    val preOrder = PreOrder(
                                        command = "kick ${props.player?.name}",
                                        sender = "test_user"
                                    )

                                    mainScope.launch {
                                        sendPreOrder(preOrder)
                                    }

                                    setOpenStatus(false)
                                }
                                + "はい"
                            }
                        }
                        DialogType.OP -> {
                            Button{
                                onClick = {
                                    // ここにOP処理を書く

                                    val preOrder = if(props.player?.isAdmin!!){
                                        PreOrder(
                                            command = "deop ${props.player?.name}",
                                            sender = "test_user"
                                        )
                                    }else {
                                        PreOrder(
                                            command = "op ${props.player?.name}",
                                            sender = "test_user"
                                        )
                                    }

                                    mainScope.launch {
                                        sendPreOrder(preOrder)
                                    }

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

suspend fun sendPreOrder(order: PreOrder){
    val deferred = mainScope.async<HttpResponse> {
        client.post(API.SERVER_COMMAND){
            body = Json.encodeToString(order)
        }
    }

    if(deferred.await().status != HttpStatusCode.Created){
        window.alert("リクエストの送信に失敗しました")
    }else{
        window.alert("リクエストを送信しました")
    }
}