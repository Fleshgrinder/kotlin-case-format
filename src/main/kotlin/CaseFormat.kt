@file:Suppress("RedundantVisibilityModifier")

package com.fleshgrinder.extensions.kotlin

private fun formatCamelCase(input: String, ignore: CharArray, upperCase: Boolean) =
    if (input.isBlank()) input else StringBuilder(input.length).also {
        var seenSeparator = upperCase
        var seenUpperCase = !upperCase

        input.forEach { c ->
            when (c) {
                in ignore -> {
                    it.append(c)
                    seenSeparator = upperCase
                    seenUpperCase = !upperCase
                }
                in '0'..'9' -> {
                    it.append(c)
                    seenSeparator = false
                    seenUpperCase = false
                }
                in 'a'..'z' -> {
                    it.append(if (seenSeparator) c.toUpperCase() else c)
                    seenSeparator = false
                    seenUpperCase = false
                }
                in 'A'..'Z' -> {
                    it.append(if (seenUpperCase) c.toLowerCase() else c)
                    seenSeparator = false
                    seenUpperCase = true
                }
                else -> if (it.isNotEmpty()) {
                    seenSeparator = true
                    seenUpperCase = false
                }
            }
        }
    }.toString()

/** Convert this string to `lowerCamelCase` */
public fun String.toLowerCamelCase(vararg ignore: Char): String =
    formatCamelCase(this, ignore, false)

/** Convert this string to `UpperCamelCase` */
public fun String.toUpperCamelCase(vararg ignore: Char): String =
    formatCamelCase(this, ignore, true)

private fun formatCase(input: String, separator: Char, ignore: CharArray, upperCase: Boolean) =
    if (input.isBlank()) input else StringBuilder(input.length).also {
        var seenSeparator = true
        var seenUpperCase = false

        input.forEach { c ->
            when (c) {
                in ignore -> {
                    it.append(c)
                    seenSeparator = true
                    seenUpperCase = false
                }
                in '0'..'9' -> {
                    it.append(c)
                    seenSeparator = false
                    seenUpperCase = false
                }
                in 'a'..'z' -> {
                    it.append(if (upperCase) c.toUpperCase() else c)
                    seenSeparator = false
                    seenUpperCase = false
                }
                in 'A'..'Z' -> {
                    if (!seenSeparator && !seenUpperCase) it.append(separator)
                    it.append(if (upperCase) c else c.toLowerCase())
                    seenSeparator = false
                    seenUpperCase = true
                }
                else -> {
                    if (!seenSeparator || !seenUpperCase) it.append(separator)
                    seenSeparator = true
                    seenUpperCase = false
                }
            }
        }
    }.toString()

private fun formatLowerCase(input: String, separator: Char, ignore: CharArray) =
    formatCase(input, separator, ignore, false)

/**
 * Convert this [String] to another lower case format that separates words by
 * the given [separator].
 */
public fun String.toLowerCaseFormat(separator: Char, vararg ignore: Char) =
    formatLowerCase(this, separator, ignore)

/** Convert this string to `lower-dash-case` */
public fun String.toLowerDashCase(vararg ignore: Char): String =
    formatLowerCase(this, '-', ignore)

/** Convert this string to `lower-dot-case` */
public fun String.toLowerDotCase(vararg ignore: Char): String =
    formatLowerCase(this, '.', ignore)

/** Convert this string to `lower_snake_case` */
public fun String.toLowerSnakeCase(vararg ignore: Char): String =
    formatLowerCase(this, '_', ignore)

private fun formatUpperCase(input: String, separator: Char, ignore: CharArray) =
    formatCase(input, separator, ignore, true)

/**
 * Convert this [String] to another upper case format that separates words by
 * the given [separator].
 */
public fun String.toUpperCaseFormat(separator: Char, vararg ignore: Char) =
    formatUpperCase(this, separator, ignore)

/** Convert this string to `UPPER-DASH-CASE` */
public fun String.toUpperDashCase(vararg ignore: Char): String =
    formatUpperCase(this, '-', ignore)

/** Convert this string to `UPPER.DOT.CASE` */
public fun String.toUpperDotCase(vararg ignore: Char): String =
    formatUpperCase(this, '.', ignore)

/** Convert this string to `UPPER_SNAKE_CASE` */
public fun String.toUpperSnakeCase(vararg ignore: Char): String =
    formatUpperCase(this, '_', ignore)
