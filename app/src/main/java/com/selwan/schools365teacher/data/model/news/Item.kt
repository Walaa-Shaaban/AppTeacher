package com.selwan.schools365teacher.data.model.news

data class Item(
    val created_at: String,
    val date: String,
    val description: String,
    val event_end: Any,
    val event_start: Any,
    val event_venue: Any,
    val feature_image: String,
    val id: String,
    val is_active: String,
    val meta_description: String,
    val meta_keyword: String,
    val meta_title: String,
    val publish: String,
    val publish_date: String,
    val sidebar: String,
    val slug: String,
    val title: String,
    val type: String,
    val url: String
)