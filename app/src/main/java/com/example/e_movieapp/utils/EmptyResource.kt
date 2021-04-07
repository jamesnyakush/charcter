package com.example.e_movieapp.utils

data class EmptyResource internal constructor(
    val status: Status,
    val exception: Exception?
) {
    companion object {
        fun success() = EmptyResource(
            Status.SUCCESS,
            null
        )

        fun error(exception: Exception? = null) =
            EmptyResource(
                Status.ERROR,
                exception
            )

        fun loading() = EmptyResource(
            Status.LOADING,
            null
        )
    }
}