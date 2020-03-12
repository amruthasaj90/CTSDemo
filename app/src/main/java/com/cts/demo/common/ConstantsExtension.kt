package com.techversant.evara.common

import com.cts.demo.model.Contact


fun getMyCategoryLists(): ArrayList<Contact> {
    var list = ArrayList<Contact>()
    list.add(


        Contact("Releases", "50,000")
    )
    list.add(
        Contact(
            "Tracks",
            "20000"
        )
    )
    list.add(
        Contact(
            "Artists",
            "3000"
        )
    )
    list.add(
        Contact(
            "Participants",
            "2000"
        )
    )
    list.add(
        Contact(
            "Plans",
            "100"
        )
    )

    return list
}
