package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import csstype.FontWeight
import csstype.integer
import csstype.number
import kotlinx.browser.window
import mui.icons.material.GitHub
import mui.material.*
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML

val Appbar = FC<Props>{
    AppBar{
        position = AppBarPosition.fixed

        sx{
            gridArea=Area.Appbar
            zIndex=integer(1500)
        }

        Toolbar{
            Typography{
                variant = "h6"
                component = ReactHTML.div

                sx{
                    flexGrow=number(1.0)
                    fontWeight = FontWeight.bold
                }
                +"Minecraft Console Controller"
            }

            Tooltip{
                title=ReactNode("View on GitHub")

                IconButton{
                    ariaLabel = "source"
                    size = Size.large

                    onClick = {
                        window.location.href = "https://github.com/rokuosan/mcc-frontend/"
                    }

                    GitHub()
                }
            }
        }
    }
}