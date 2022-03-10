package com.deviseworks.mcc.frontend.component

import com.deviseworks.mcc.frontend.entity.Tabs
import com.deviseworks.mcc.frontend.hook.useTabs
import react.FC
import react.PropsWithChildren
import react.createContext

val TabsContext = createContext<Tabs>()

val TabsModule = FC<PropsWithChildren> { props ->
    val users = useTabs()

    TabsContext.Provider(users){
        +props.children
    }
}