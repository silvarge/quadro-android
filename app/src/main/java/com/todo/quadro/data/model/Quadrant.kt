package com.todo.quadro.data.model

enum class Quadrant(
    val title: String,
    val subtitle: String
) {
    URGENT_IMPORTANT(
        title = "실행",
        subtitle = "긴급하고 중요한"
    ),
    NOT_URGENT_IMPORTANT(
        title = "계획",
        subtitle = "긴급하지 않지만 중요한"
    ),
    URGENT_NOT_IMPORTANT(
        title = "위임",
        subtitle = "긴급하지만 중요하지 않은"
    ),
    NOT_URGENT_NOT_IMPORTANT(
        title = "제거",
        subtitle = "긴급하지도 중요하지도 않은"
    )
}
