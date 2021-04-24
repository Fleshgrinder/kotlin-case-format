@file:Suppress("NOTHING_TO_INLINE")

package com.fleshgrinder.extensions.kotlin

import com.fleshgrinder.kotlin.toLowerCamelCase as newToLowerCamelCase
import com.fleshgrinder.kotlin.toLowerCaseFormat as newToLowerCaseFormat
import com.fleshgrinder.kotlin.toLowerDashCase as newToLowerDashCase
import com.fleshgrinder.kotlin.toLowerSnakeCase as newToLowerSnakeCase
import com.fleshgrinder.kotlin.toUpperCamelCase as newToUpperCamelCase
import com.fleshgrinder.kotlin.toUpperCaseFormat as newToUpperCaseFormat
import com.fleshgrinder.kotlin.toUpperDashCase as newToUpperDashCase
import com.fleshgrinder.kotlin.toUpperSnakeCase as newToUpperSnakeCase

/**
 * Format this [String] in **lowerCamelCase** (aka. _mixedCase_,
 * _Smalltalk case_, …).
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **lowerCamelCase** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toLowerCamelCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toLowerCamelCase(*ignore)", "com.fleshgrinder.kotlin.toLowerCamelCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toLowerCamelCase(vararg ignore: Char): String =
    newToLowerCamelCase(*ignore)

/**
 * Format this [String] in **UpperCamelCase** (aka. _PascalCase_, _WikiCase_,
 * …).
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **UpperCamelCase** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toUpperCamelCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toUpperCamelCase(*ignore)", "com.fleshgrinder.kotlin.toUpperCamelCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toUpperCamelCase(vararg ignore: Char): String =
    newToUpperCamelCase(*ignore)

/**
 * Format this [String] in another **lower case** format where words are
 * separated by the given [separator].
 *
 * @param separator to separate words with
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **lower case** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toLowerCaseFormat
 */
@Deprecated(
    "package changed",
    ReplaceWith("toLowerCaseFormat(separator, *ignore)", "com.fleshgrinder.kotlin.toLowerCaseFormat"),
    DeprecationLevel.WARNING
)
public inline fun String.toLowerCaseFormat(separator: Char, vararg ignore: Char): String =
    newToLowerCaseFormat(separator, *ignore)

/**
 * Format this [String] in **lower-dash-case** (aka. _lower hyphen case_,
 * _lower kebab case_, …).
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **lower-dash-case** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toLowerDashCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toLowerDashCase(*ignore)", "com.fleshgrinder.kotlin.toLowerDashCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toLowerDashCase(vararg ignore: Char): String =
    newToLowerDashCase(*ignore)

/**
 * Format this [String] in **lower_snake_case**.
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **lower_snake_case** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toLowerSnakeCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toLowerSnakeCase(*ignore)", "com.fleshgrinder.kotlin.toLowerSnakeCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toLowerSnakeCase(vararg ignore: Char): String =
    newToLowerSnakeCase(*ignore)

/**
 * Format this [String] in another **UPPER CASE** format where words are
 * separated by the given [separator].
 *
 * @param separator to separate words with
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **UPPER CASE** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toUpperCaseFormat
 */
@Deprecated(
    "package changed",
    ReplaceWith("toUpperCaseFormat(separator, *ignore)", "com.fleshgrinder.kotlin.toUpperCaseFormat"),
    DeprecationLevel.WARNING
)
public inline fun String.toUpperCaseFormat(separator: Char, vararg ignore: Char): String =
    newToUpperCaseFormat(separator, *ignore)

/**
 * Format this [String] in **UPPER-DASH-CASE** (aka. _upper hyphen case_,
 * _upper kebab case_, …).
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **UPPER-DASH-CASE** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toUpperDashCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toUpperDashCase(*ignore)", "com.fleshgrinder.kotlin.toUpperDashCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toUpperDashCase(vararg ignore: Char): String =
    newToUpperDashCase(*ignore)

/**
 * Format this [String] in **UPPER_SNAKE_CASE** (aka. _screaming snake case_).
 *
 * @param ignore can be used to specify characters that should be included
 *   verbatim in the result, note that they are still considered separators
 * @receiver [String] to format
 * @return **UPPER_SNAKE_CASE** formatted [String]
 * @since 0.1.0
 * @sample com.fleshgrinder.kotlin.CaseFormatTest.toUpperSnakeCase
 */
@Deprecated(
    "package changed",
    ReplaceWith("toUpperSnakeCase(*ignore)", "com.fleshgrinder.kotlin.toUpperSnakeCase"),
    DeprecationLevel.WARNING
)
public inline fun String.toUpperSnakeCase(vararg ignore: Char): String =
    newToUpperSnakeCase(*ignore)
