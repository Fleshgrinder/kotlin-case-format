@file:Suppress("RedundantVisibilityModifier")

package com.fleshgrinder.extensions

private fun String.caseFormat(initial: Boolean, op: (StringBuilder, Boolean, Char) -> Boolean): String {
    require(isNotEmpty()) { "cannot format empty string" }

    return StringBuilder(length).also { fold(initial) { acc, c -> op(it, acc, c) } }.toString()
}

private fun String.fromCamelCase(separator: Char, upperCase: Boolean): String =
    caseFormat(false) { it, insertSeparator, c ->
        when {
            c.isUpperCase() -> {
                if (insertSeparator) it.append(separator)
                it.append(if (upperCase) c else c.toLowerCase())
                !insertSeparator
            }
            c.isLowerCase() -> {
                it.append(if (upperCase) c.toUpperCase() else c)
                true
            }
            c.isDigit() -> {
                it.append(c)
                true
            }
            else -> {
                it.append(c)
                false
            }
        }
    }

private fun String.toCamelCase(separator: Char, upperCase: Boolean): String =
    caseFormat(upperCase) { it, seenSeparator, c ->
        (c == separator).apply {
            if (!this) it.append(if (seenSeparator) c.toUpperCase() else c.toLowerCase())
        }
    }

public fun String.camelCaseToLowerCase(separator: Char): String = fromCamelCase(separator, false)
public fun String.camelCaseToLowerDashCase(): String = camelCaseToLowerCase('-')
public fun String.camelCaseToLowerDotCase(): String = camelCaseToLowerCase('.')
public fun String.camelCaseToLowerSnakeCase(): String = camelCaseToLowerCase('_')

public fun String.camelCaseToUpperCase(separator: Char): String = fromCamelCase(separator, true)
public fun String.camelCaseToUpperDashCase(): String = camelCaseToUpperCase('-')
public fun String.camelCaseToUpperDotCase(): String = camelCaseToUpperCase('.')
public fun String.camelCaseToUpperSnakeCase(): String = camelCaseToUpperCase('_')

public fun String.toLowerCamelCase(separator: Char): String = toCamelCase(separator, false)
public fun String.dashCaseToLowerCamelCase(): String = toLowerCamelCase('-')
public fun String.dotCaseToLowerCamelCase(): String = toLowerCamelCase('.')
public fun String.snakeCaseToLowerCamelCase(): String = toLowerCamelCase('_')

public fun String.toUpperCamelCase(separator: Char): String = toCamelCase(separator, true)
public fun String.dashCaseToUpperCamelCase(): String = toUpperCamelCase('-')
public fun String.dotCaseToUpperCamelCase(): String = toUpperCamelCase('.')
public fun String.snakeCaseToUpperCamelCase(): String = toUpperCamelCase('_')

/**
 * Convert this string to a string that can safely be used as the name of an
 * [environment variable][System.getenv].
 *
 * @throws IllegalArgumentException if the object this function is referencing
 *   [is empty][String.isEmpty].
 */
public fun String.toEnvVarName(): String =
    caseFormat(false) { it, separatorAllowed, c ->
        when (c) {
            in 'A'..'Z' -> {
                if (separatorAllowed) it.append("_$c")
                else it.append(c)
                false
            }
            in 'a'..'z' -> {
                it.append(c.toUpperCase())
                true
            }
            in '0'..'9' -> {
                it.append(c)
                true
            }
            else -> {
                it.append('_')
                false
            }
        }
    }
