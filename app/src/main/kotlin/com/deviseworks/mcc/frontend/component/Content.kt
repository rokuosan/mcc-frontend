package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import csstype.px
import mui.material.Box
import mui.material.Typography
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML
import react.router.Route
import react.router.Routes
import react.useContext

val Content = FC<Props> {
    val tabs = useContext(TabsContext)

    Box{
        component = ReactHTML.main
        sx{
            gridArea = Area.Content
            padding = 30.px
        }

        Routes{
            Route{
                path="/"

                for((key, _, Component) in tabs){
                    Route{
                        path = key
                        element = Component.create()
                    }
                }

                Route{
                    path = "*"
                    element = Typography.create{
                        + "404 Page Not Found"
                    }
                }
            }
        }
    }

}