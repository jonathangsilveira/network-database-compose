package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import androidx.compose.runtime.Immutable
import kotlinx.datetime.Instant

@Immutable
data class ChecklistViewData(
    val uuid: String? = null,
    val checklistId: Long = 0,
    val title: String? = null,
    val createdAt: Instant? = null,
    val items: List<ChecklistItemViewData> = listOf()
)

@Immutable
data class ChecklistItemViewData(
    val checklistItemUuid: String? = null,
    val isChecked: Boolean = false,
    val isRemoved: Boolean = false,
    val description: String? = null
)
