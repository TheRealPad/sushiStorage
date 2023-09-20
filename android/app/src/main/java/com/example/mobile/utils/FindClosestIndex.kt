package com.example.mobile.utils

fun findClosestIndex(targetNumber: Int, numbers: List<Int>): Int {
    var closestIndex = 0
    var closestDifference = Int.MAX_VALUE

    for (index in numbers.indices) {
        val difference = Math.abs(targetNumber - numbers[index])
        if (difference < closestDifference) {
            closestIndex = index
            closestDifference = difference
        }
    }

    return closestIndex
}