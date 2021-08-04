package com.proway.listainterfaceevents

fun main() {

    println("arthur".concatNameWithCompany())

    val cpfMasked = "0407634589".addMaskCpf()

    println(cpfMasked)

}

fun String.concatNameWithCompany(): String {
    return "$this - Proway"
}

fun String.removerMaskCpf(): String {
    return replace(".", "").replace("-", "")
}

fun String.addMaskCpf(): String? {
    if (length == 11) {
        return substring(0, 3) + "." +
                substring(3, 6) + "." +
                substring(6, 9) + "-" +
                substring(9, 11)
    }
    return null
}