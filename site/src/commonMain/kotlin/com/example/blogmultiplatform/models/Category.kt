package com.example.blogmultiplatform.models
import kotlinx.serialization.Serializable
import com.example.blogmultiplatform.CategoryCommon

@Serializable
enum class Category(override val color: String): CategoryCommon {
    Technology(color = "#00FF94"), // Green
    Programming(color = "#FFEC45"), // Yellow
    Design(color = "#8B6DFF") // Purple
}