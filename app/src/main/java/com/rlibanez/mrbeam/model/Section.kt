package com.rlibanez.mrbeam.model

import com.google.gson.annotations.SerializedName

data class Section(
    // El nombre de la columna de la db, por si queremos cambiar el nombre de la variable
    @SerializedName("name")
    val name: String,
    val h: Double,
    val b: Double,
    val tw: Double,
    val tf: Double,
    val r1: Double,
    val r2: Double,
    val hi: Double?,
    val d: Double,
    val dmax: String,
    val emin: Int,
    val emax: Int,
    val pmin: Double?,
    val pmax: Double?,
    val iyc: Double,
    val izc: Double,
    val ss: Double,
    val ys: Double,
    val ym: Double,
    val yS235: Boolean,
    val yS355: Boolean,
    val yS460: Boolean?,
    val xS235: Boolean,
    val xS355: Boolean,
    val xS460: Boolean?,
    val avz: Double,
    val iz: Double,
    val welz: Double,
    val wplz: Double,
    val g: Double,
    val a: Double,
    val en1002522004: Boolean,
    val en1002542004: Boolean,
    val en102252001: Boolean,
    val wely: Double,
    val ag: Double,
    val wply: Double,
    val it: Double,
    val iw: Double,
    val al: Double,
    val iy: Double
)
