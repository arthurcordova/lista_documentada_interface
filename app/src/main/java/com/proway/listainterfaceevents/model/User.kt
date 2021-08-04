package com.proway.listainterfaceevents.model

data class User(
    val cpf: String,
    val password: String
) {

    fun isValidCpf(): Boolean {
        return cpf.length == 11
    }

    fun isValidPassword(): Boolean {
        return password.length >= 6
    }

}



