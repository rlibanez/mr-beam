package com.rlibanez.mrbeam.model

class Units {

    companion object {
        private val unit = mapOf(
            "G" to "kg/m",
            "h" to "mm",
            "b" to "mm",
            "tw" to "mm",
            "tf" to "mm",
            "r1" to "mm",
            "r2" to "mm",
            "A" to "mm\u00B2x10\u00B2",
            "hi" to "mm",
            "d" to "mm",
            "dmax" to "",
            "emin" to "mm",
            "emax" to "mm",
            "pmin" to "mm",
            "pmax" to "mm",
            "Al" to "m\u00B2/m",
            "Ag" to "m\u00B2/t",
            "Iy" to "mm\u2074x10\u2074",
            "Wely" to "mm\u00B3x10\u00B3",
            "Wply" to "mm\u00B3x10\u00B3",
            "Iy" to "mmx10",
            "Avz" to "mm\u00B2x10\u00B2",
            "Iz" to "mm\u2074x10\u2074",
            "Welz" to "mm\u00B3x10\u00B3",
            "Wplz" to "mm\u00B3x10\u00B3",
            "iz" to "mmx10",
            "ss" to "mm",
            "It" to "mm\u2074x10\u2074",
            "Iw" to "mm\u2076x10\u2079",
            "ys" to "mmx10",
            "ym" to "mmx10",
            "yS235" to "",
            "yS355" to "",
            "yS460" to "",
            "xS235" to "",
            "xS355" to "",
            "xS460" to "",
            "EN1002522004" to "",
            "En1002542004" to "",
            "EN102252001" to "",
        )

        fun getUnit(name: String): String? {
            return unit[name]
        }
    }
}