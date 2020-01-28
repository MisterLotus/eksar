package com.eksar.model

data class UserModel constructor(
    var userId: Long,
    var name: String,
    var email: String,
    var specialInfo: String?
) {


}