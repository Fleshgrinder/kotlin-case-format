@file:Suppress("NOTHING_TO_INLINE")

package com.fleshgrinder.caseFormat

public inline fun String.isLowerSnakeCase(): Boolean =
    isLowerCaseFormat('_')

public inline fun String.isLowerSnakeCase(segmentSeparator: Char): Boolean =
    isLowerCaseFormat('_', segmentSeparator)

public inline fun String.isUpperSnakeCase(): Boolean =
    isUpperCaseFormat('_')

public inline fun String.isUpperSnakeCase(segmentSeparator: Char): Boolean =
    isUpperCaseFormat('_', segmentSeparator)

public inline fun String.toLowerSnakeCase(): String =
    toLowerCaseFormat('_')

public inline fun String.toLowerSnakeCase(segmentSeparator: Char): String =
    toLowerCaseFormat('_', segmentSeparator)

public inline fun String.toUpperSnakeCase(): String =
    toUpperCaseFormat('_')

public inline fun String.toUpperSnakeCase(segmentSeparator: Char): String =
    toUpperCaseFormat('_', segmentSeparator)
