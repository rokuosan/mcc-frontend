package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import com.deviseworks.mcc.frontend.common.Sizes
import csstype.Color
import csstype.None
import mui.icons.material.ListAltOutlined
import mui.icons.material.PeopleAltOutlined
import mui.icons.material.SettingsOutlined
import mui.material.*
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.css.css
import react.router.dom.NavLink
import react.router.useLocation
import react.useContext

val DrawerPermanent = FC<Props>{
    val tabs = useContext(TabsContext)
    val lastPathname = useLocation().pathname.substringAfterLast("/")

    Box{
        sx{
            gridArea = Area.Drawer
        }
        Drawer{
            variant=DrawerVariant.permanent
            anchor=DrawerAnchor.left

            Toolbar()

            List{
                sx{
                    width=Sizes.Drawer.Width
                }

                for((key, name) in tabs){
                    NavLink{
                        to = key

                        css{
                            textDecoration = None.none
                            color = Color.currentcolor
                        }

                        ListItemButton{
                            selected = key == lastPathname

                            ListItemIcon{
                                when(key){
                                    "player" -> {
                                        PeopleAltOutlined()
                                    }
                                    "console" -> {
                                        ListAltOutlined()
                                    }
                                    "etc" -> {
                                        SettingsOutlined()
                                    }
                                }
                            }

                            ListItemText{
                                primary=ReactNode(name)
                            }
                        }
                    }
                }
            }
        }
    }
}