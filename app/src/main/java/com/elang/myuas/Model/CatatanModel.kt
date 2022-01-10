package com.elang.myuas.Model

class CatatanModel (
    val catatan: List<Data>
) {
    data class Data (val nim:String?, val nama:String?)
}