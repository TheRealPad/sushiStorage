package com.example.mobile.dto

import java.util.UUID

data class Sushi (
    val uuid: UUID,
    val name: String,
    val description: String,
    val iconId: Int
    )