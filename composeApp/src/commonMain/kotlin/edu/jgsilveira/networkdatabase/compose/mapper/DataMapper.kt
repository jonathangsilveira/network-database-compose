package edu.jgsilveira.networkdatabase.compose.mapper

interface DataMapper<MODEL, ENTITY> {
    fun toEntity(model: MODEL): ENTITY
    fun toModel(entity: ENTITY): MODEL
}