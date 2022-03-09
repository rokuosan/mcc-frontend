package com.deviseworks.mcc.frontend

import com.deviseworks.mcc.frontend.common.Area
import com.deviseworks.mcc.frontend.common.Sizes
import com.deviseworks.mcc.frontend.component.Appbar
import com.deviseworks.mcc.frontend.component.DrawerPermanent
import com.deviseworks.mcc.frontend.component.SampleTheme
import csstype.Auto
import csstype.Display
import csstype.GridTemplateAreas
import csstype.array
import kotlinx.browser.document
import mui.material.Box
import mui.material.CssBaseline
import mui.system.ThemeProvider
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.dom.render

fun main(){
    render(
        element = App.create(),
        container = document.getElementById("root")!!
    )
}

private val App = FC<Props>{
    ThemeProvider{
        this.theme=SampleTheme
        CssBaseline()

        Box{
            sx{
                display=Display.grid

                gridTemplateRows = array(
                    Sizes.Appbar.Height,
                    Auto.auto
                )

                gridTemplateColumns = array(
                    Sizes.Drawer.Width,
                    Auto.auto
                )

                gridTemplateAreas = GridTemplateAreas(
                    arrayOf(Area.Appbar, Area.Appbar),
                    arrayOf(Area.Drawer, Area.Content)
                )
            }
            Appbar()
            DrawerPermanent()
        }
    }
}