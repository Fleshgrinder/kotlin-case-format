package com.fleshgrinder.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(Lifecycle.PER_CLASS)
class StringTest {
    @ParameterizedTest
    @CsvSource(
        "LOWER_CAMEL_CASE, lowerCamelCase",
        "UPPER_CAMEL_CASE, UpperCamelCase",
        "LOWER_DASH_CASE, lower-dash-case",
        "UPPER_DASH_CASE, UPPER-DASH-CASE",
        "LOWER_DOT_CASE, lower.dot.case",
        "UPPER_DOT_CASE, UPPER.DOT.CASE",
        "LOWER_SNAKE_CASE, lower_snake_case",
        "UPPER_SNAKE_CASE, UPPER_SNAKE_CASE",
        "_UNICODE_, ©unicode®"
    )
    fun toEnvVarName(expected: String, input: String) {
        assertEquals(expected, input.toEnvVarName())
    }

    @ParameterizedTest
    @CsvSource(
        "lower|camel|case, lowerCamelCase, |",
        "upper|camel|case, UpperCamelCase, |"
    )
    fun camelCaseToLowerCase(expected: String, input: String, separator: Char) {
        assertEquals(expected, input.camelCaseToLowerCase(separator))
    }

    @ParameterizedTest
    @CsvSource(
        "lower-camel-case, lowerCamelCase",
        "upper-camel-case, UpperCamelCase"
    )
    fun camelCaseToLowerDashCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToLowerDashCase())
    }

    @ParameterizedTest
    @CsvSource(
        "lower.camel.case, lowerCamelCase",
        "upper.camel.case, UpperCamelCase"
    )
    fun camelCaseToLowerDotCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToLowerDotCase())
    }

    @ParameterizedTest
    @CsvSource(
        "lower_camel_case, lowerCamelCase",
        "upper_camel_case, UpperCamelCase"
    )
    fun camelCaseToLowerSnakeCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToLowerSnakeCase())
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER|CAMEL|CASE, lowerCamelCase, |",
        "UPPER|CAMEL|CASE, UpperCamelCase, |"
    )
    fun camelCaseToUpperCase(expected: String, input: String, separator: Char) {
        assertEquals(expected, input.camelCaseToUpperCase(separator))
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER-CAMEL-CASE, lowerCamelCase",
        "UPPER-CAMEL-CASE, UpperCamelCase"
    )
    fun camelCaseToUpperDashCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToUpperDashCase())
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER.CAMEL.CASE, lowerCamelCase",
        "UPPER.CAMEL.CASE, UpperCamelCase"
    )
    fun camelCaseToUpperDotCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToUpperDotCase())
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER_CAMEL_CASE, lowerCamelCase",
        "UPPER_CAMEL_CASE, UpperCamelCase"
    )
    fun camelCaseToUpperSnakeCase(expected: String, input: String) {
        assertEquals(expected, input.camelCaseToUpperSnakeCase())
    }
}
