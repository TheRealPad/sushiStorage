package com.example.mobile.utils

fun generateScreenPositions(n: Int, screenWidth: Int): List<Int> {
    val screenPositions = mutableListOf<Int>()

    for (i in 0 until n) {
        val position = i * screenWidth
        screenPositions.add(position)
    }

    return screenPositions
}