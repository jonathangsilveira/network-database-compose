package edu.jgsilveira.networkdatabase.compose.features.checklist.list

import kotlinx.datetime.Instant

data class Checklist(
    val id: Int,
    val title: String,
    val createdAt: Instant
)
