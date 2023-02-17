package com.pdm.tracker_domain.use_case

import com.pdm.tracker_domain.model.TrackableFood
import com.pdm.tracker_domain.repository.TrackerRepository

class SearchFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        return if (query.isEmpty()) {
            Result.success(emptyList())
        } else {
            repository.searchFood(query.trim(), page, pageSize)
        }
    }
}