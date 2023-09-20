package com.example.mobile.utils

fun generateScreenPositions(count: Int): List<Int> {
    val screenPositions = mutableListOf<Int>()

    for (i in 0 until count) {
        when (i) {
            0 -> screenPositions.add(0)
            1 -> screenPositions.add(1430)
            else -> {
                val previousValue = screenPositions[i - 1]
                screenPositions.add(previousValue + 1435)
            }
        }
    }

    return screenPositions
}