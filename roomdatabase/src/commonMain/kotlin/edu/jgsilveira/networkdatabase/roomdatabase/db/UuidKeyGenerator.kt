package edu.jgsilveira.networkdatabase.roomdatabase.db

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun generateUuidKey(): String = Uuid.random().toString()