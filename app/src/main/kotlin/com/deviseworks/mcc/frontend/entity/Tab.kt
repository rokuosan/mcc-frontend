package com.deviseworks.mcc.frontend.entity

import react.FC
import react.Props

data class Tab(
    val key: String,
    val name: String,
    val Component: FC<Props>
)

typealias Tabs = Iterable<Tab>