package com.pdm.tracker_domain.use_case

import com.pdm.tracker_domain.model.MealType
import com.pdm.tracker_domain.model.TrackableFood
import com.pdm.tracker_domain.model.TrackedFood
import com.pdm.tracker_domain.repository.TrackerRepository
import java.time.LocalDate

class TrackFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100) * amount),
                protein = ((food.proteinPer100g / 100) * amount),
                fat = ((food.fatPer100g / 100) * amount),
                calories = ((food.caloriesPer100g / 100) * amount),
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date
            )
        )
    }
}