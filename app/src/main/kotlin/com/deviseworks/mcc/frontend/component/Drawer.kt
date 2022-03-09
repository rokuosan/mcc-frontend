package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.common.Area
import com.deviseworks.mcc.frontend.common.Sizes
import mui.icons.material.ListAltOutlined
import mui.icons.material.PeopleAltOutlined
import mui.icons.material.SettingsOutlined
import mui.material.*
import mui.system.sx
import react.FC
import react.Props
import react.key

val DrawerPermanent = FC<Props>{
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

                listOf("プレイヤー", "コンソール", "その他").forEachIndexed { index, s ->
                    ListItemButton{
                        key=s
                        ListItemIcon{
                            when(index){
                                0 -> {
                                    PeopleAltOutlined()
                                }
                                1 -> {
                                    ListAltOutlined()
                                }
                                2 -> {
                                    SettingsOutlined()
                                }
                            }
                        }
                        ListItemText{
                            +s
                        }
                    }
                }
            }
        }
    }
}