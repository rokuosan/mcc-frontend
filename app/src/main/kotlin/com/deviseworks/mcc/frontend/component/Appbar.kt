package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import csstype.integer
import csstype.number
import kotlinx.browser.window
import mui.icons.material.GitHub
import mui.material.*
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.dom.aria.AriaHasPopup
import react.dom.aria.ariaHasPopup
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML

val Appbar = FC<Props>{
    AppBar{
        position = AppBarPosition.static

        sx{
            gridArea=Area.Appbar
            zIndex=integer(1500)
        }

        Toolbar{
//            IconButton{
//                size = Size.large
//                edge = IconButtonEdge.start
//                color = IconButtonColor.inherit
//                ariaLabel = "menu"
//
//                sx{
//                    marginRight = 2.px
//                }
//
//                Menu()
//
//            }

            Typography{
                variant = "h6"
                component = ReactHTML.div

                sx{
                    flexGrow=number(1.0)
                }
                +"Minecraft Console Controller"
            }

            Tooltip{
                title=ReactNode("View on GitHub")

                IconButton{
                    ariaLabel = "source"
                    ariaHasPopup =AriaHasPopup.`false`
                    size = Size.large
                    color = IconButtonColor.inherit

                    onClick = {
                        window.location.href = "https://github.com/rokuosan/mcc-frontend/"
                    }

                    GitHub()
                }
            }
        }
    }
}