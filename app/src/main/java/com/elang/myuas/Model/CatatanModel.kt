package com.elang.myuas.Model

class CatatanModel (
    val catatan: List<Data>
) {
    data class Data (val nama:String?, val waktu:String?)
}