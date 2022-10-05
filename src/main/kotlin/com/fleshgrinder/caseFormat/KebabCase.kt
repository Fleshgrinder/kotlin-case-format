@file:Suppress("NOTHING_TO_INLINE")

package com.fleshgrinder.caseFormat

public inline fun String.isLowerKebabCase(): Boolean =
    isLowerCaseFormat('-')

public inline fun String.isLowerKebabCase(segmentSeparator: Char): Boolean =
    isLowerCaseFormat('-', segmentSeparator)

public inline fun String.isUpperKebabCase(): Boolean =
    isUpperCaseFormat('-')

public inline fun String.isUpperKebabCase(segmentSeparator: Char): Boolean =
    isUpperCaseFormat('-', segmentSeparator)

public inline fun String.toLowerKebabCase(): String =
    toLowerCaseFormat('-')

public inline fun String.toLowerKebabCase(segmentSeparator: Char): String =
    toLowerCaseFormat('-', segmentSeparator)

public inline fun String.toUpperKebabCase(): String =
    toUpperCaseFormat('-')

public inline fun String.toUpperKebabCase(segmentSeparator: Char): String =
    toUpperCaseFormat('-', segmentSeparator)
