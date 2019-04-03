package com.sirionrazzer.diary.models

import io.realm.RealmObject

open class TrackItem (
    var id: String,
    var deleted: Boolean,
    var name: String,
    var imageOn: Int,
    var imageOff: Int,
    var hasTextField: Boolean,
    var hasNumberField: Boolean,
    open var status: Boolean, // on/off status of item
    open var textField: String?, // optional text field
    open var numberField: Float?, // optional number field
    open var date: Long // creation time like Calendar.getInstance().timeInMillis
) : RealmObject() {
    // constructor used by Realm
    constructor() : this("",
        false,
        "",
        0,
        0,
        false,
        false,
        false,
        "",
        0f,
        0
        )
}
