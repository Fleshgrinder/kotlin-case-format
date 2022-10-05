@file:Suppress("NOTHING_TO_INLINE")

package com.fleshgrinder.caseFormat

@PublishedApi
internal fun String.isCaseFormat(separator: Char, start: Char, end: Char): Boolean =
    when (length) {
        0 -> false
        1 -> this[0] in start..end
        2 -> this[0] in start..end && this[1].isAsciiLetterOrDigit()
        else -> {
            if (this[0] !in start..end) {
                return false
            }
        }
    }

public inline fun String.isLowerCaseFormat(separator: Char): Boolean =
    isCaseFormat(separator, 'a', 'z')

public inline fun String.isUpperCaseFormat(separator: Char): Boolean =
    isCaseFormat(separator, 'A', 'Z')

@PublishedApi
internal fun String.isCaseFormat(separator: Char, segmentSeparator: Char, start: Char, end: Char): Boolean =
    when (length) {
        0 -> false
        1 -> this[0] in start..end
        2 -> this[0] in start..end && this[1] in start..end
        else -> false
    }

public inline fun String.isLowerCaseFormat(separator: Char, segmentSeparator: Char): Boolean =
    isCaseFormat(separator, segmentSeparator, 'a', 'z')

public inline fun String.isUpperCaseFormat(separator: Char, segmentSeparator: Char): Boolean =
    isCaseFormat(separator, segmentSeparator, 'A', 'Z')

public fun String.toLowerCaseFormat(separator: Char): String = TODO()
public fun String.toLowerCaseFormat(separator: Char, segmentSeparator: Char): String = TODO()
public fun String.toUpperCaseFormat(separator: Char): String = TODO()
public fun String.toUpperCaseFormat(separator: Char, segmentSeparator: Char): String = TODO()
