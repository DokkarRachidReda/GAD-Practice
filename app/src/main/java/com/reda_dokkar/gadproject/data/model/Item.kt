package com.reda_dokkar.gadproject.data.model

abstract class Item(
    val badgeUrl: String,
    val country: String,
    val name: String
)

 class LearningItem
     (
      badgeUrl: String,
      country: String,
      name: String,
      val hours: Int
     )
     : Item(
        badgeUrl,
        country,
        name
     )


class SkillItem
    (
    badgeUrl: String,
    country: String,
    name: String,
    val score: Int
   )
    : Item(
    badgeUrl,
    country,
    name
   )