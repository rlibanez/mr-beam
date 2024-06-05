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
            "A" to "x10\u00B2 mm\u00B2",
            "hi" to "mm",
            "d" to "mm",
            "dmax" to "",
            "emin" to "mm",
            "emax" to "mm",
            "pmin" to "mm",
            "pmax" to "mm",
            "Al" to "m\u00B2/m",
            "Ag" to "m\u00B2/t",
            "Iy" to "x10\u2074 mm\u2074",
            "Wely" to "x10\u00B3 mm\u00B3",
            "Wply" to "x10\u00B3 mm\u00B3",
            "iy" to "x10 mm",
            "Avz" to "x10\u00B2 mm\u00B2",
            "Iz" to "x10\u2074 mm\u2074",
            "Welz" to "x10\u00B3 mm\u00B3",
            "Wplz" to "x10\u00B3 mm\u00B3",
            "iz" to "x10 mm",
            "ss" to "mm",
            "It" to "x10\u2074 mm\u2074",
            "Iw" to "x10\u2079 mm\u2076",
            "ys" to "x10 mm",
            "ym" to "x10 mm",
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