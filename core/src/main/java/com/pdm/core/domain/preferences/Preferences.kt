package com.pdm.core.domain.preferences

import com.pdm.core.domain.model.ActivityLevel
import com.pdm.core.domain.model.Gender
import com.pdm.core.domain.model.GoalType
import com.pdm.core.domain.model.UserInfo

interface Preferences {
    fun saveGender(gender: Gender)
    fun saveGoalType(goalType: GoalType)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)
    fun saveActivityLevel(activityLevel: ActivityLevel)

    fun loadUserInfo(): UserInfo

    companion object {
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARB_RATIO = "carb_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
    }
}