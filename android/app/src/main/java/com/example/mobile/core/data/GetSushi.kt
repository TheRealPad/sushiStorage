package com.example.mobile.core.data

import com.example.mobile.core.dto.Sushi

class HandleSushi() {
    private val sushi: List<Sushi> = SampleData.sushiSample

    fun getSushiData(): List<Sushi> {
        return this.sushi
    }
}