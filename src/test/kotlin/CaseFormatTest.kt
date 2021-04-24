package com.fleshgrinder.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Note that this class is `private` so that it is excluded from the generated
 * docs. Note further that the bodies of the test methods are part of the public
 * docs, hence, the text should be written in a way that helps a person who is
 * interested in learning about the library. Docs inclusion is also the reason
 * why the tests are not parameterized but instead use multiple assertions;
 * annotations are never included in the docs only the function bodies.
 */
private class CaseFormatTest {
    @Test
    fun toLowerCamelCase() {
        assertEquals("", "".toLowerCamelCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("lowerCamelCase", "lowerCamelCase".toLowerCamelCase()) {
            "a string that is already in `lowerCamelCase` is unchanged"
        }

        assertEquals("upperCamelCase", "UpperCamelCase".toLowerCamelCase()) {
            "a string that is in `UpperCamelCase` has its first character decapitalized"
        }

        listOf(' ', '-', '_').forEach { sep ->
            assertEquals("lowerCamelCase", "lower${sep}camel${sep}case".toLowerCamelCase()) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("uniCode", "©®UNI¤CODE®©".toLowerCamelCase()) {
            "Unicode characters are removed"
        }

        assertEquals("java.properties.keyName", "JAVA.Properties.Key-Name".toLowerCamelCase('.')) {
            "ignored characters are included in the result verbatim but still considered to be word separators"
        }

        assertEquals("a.b-c_d", "a.b-c_d".toLowerCamelCase('.', '-', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("weirDlYMiXedCaSing", "WeirDlY-MiXed_CaSing".toLowerCamelCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toUpperCamelCase() {
        assertEquals("", "".toUpperCamelCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("UpperCamelCase", "UpperCamelCase".toUpperCamelCase()) {
            "a string that is already in `UpperCamelCase` is unchanged"
        }

        assertEquals("LowerCamelCase", "lowerCamelCase".toUpperCamelCase()) {
            "a string that is in `lowerCamelCase` has its first character capitalized"
        }

        listOf(' ', '-', '_').forEach { sep ->
            assertEquals("UpperCamelCase", "upper${sep}camel${sep}case".toUpperCamelCase()) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("UniCode", "©®UNI¤CODE®©".toUpperCamelCase()) {
            "Unicode characters are removed"
        }

        assertEquals("Java.Properties.KeyName", "JAVA.Properties.Key-Name".toUpperCamelCase('.')) {
            "ignored characters are included in the result verbatim but still considered to be word separators"
        }

        assertEquals("A.B-C_D", "a.b-c_d".toUpperCamelCase('.', '-', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("WeirDlYMiXedCaSing", "WeirDlY-MiXed_CaSing".toUpperCamelCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toLowerCaseFormat() {
        assertEquals("", "".toLowerCaseFormat('|')) {
            "empty strings are returned as-is"
        }

        assertEquals("lower|case|format", "lower|case|format".toLowerCaseFormat('|')) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("lower|case|format", "LOWER|CASE|FORMAT".toLowerCaseFormat('|')) {
            "a string that is all upper is properly converted to lower"
        }

        assertEquals("lower|case|format", "LowerCaseFormat".toLowerCaseFormat('|')) {
            "ASCII upper letters A..Z are word separators"
        }

        listOf(' ', '-', '_').forEach { sep ->
            assertEquals("lower|case|format", "lower${sep}case${sep}format".toLowerCaseFormat('|')) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("||uni|code||", "©®UNI¤CODE®©".toLowerCaseFormat('|')) {
            "Unicode characters are replaced"
        }

        assertEquals("dot.separated.string", "dot.separated.string".toLowerCaseFormat('|', '.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("a.b-c_d", "a.b-c_d".toLowerCaseFormat('|', '.', '-', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("weir|dl|y|mi|xed|ca|sing", "WeirDlY-MiXed_CaSing".toLowerCaseFormat('|')) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toLowerDashCase() {
        assertEquals("", "".toLowerDashCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("lower-dash-case", "lower-dash-case".toLowerDashCase()) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("lower-dash-case", "LOWER-DASH-CASE".toLowerDashCase()) {
            "a string that is all upper is properly converted to lower"
        }

        listOf(' ', '|', '_').forEach { sep ->
            assertEquals("lower-dash-case", "lower${sep}dash${sep}case".toLowerDashCase()) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("--uni-code--", "©®UNI¤CODE®©".toLowerDashCase()) {
            "Unicode characters are replaced"
        }

        assertEquals("dot.separated.string", "dot.separated.string".toLowerDashCase('.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("a.b|c_d", "a.b|c_d".toLowerDashCase('.', '|', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("weir-dl-y-mi-xed-ca-sing", "WeirDlY-MiXed_CaSing".toLowerDashCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toLowerSnakeCase() {
        assertEquals("", "".toLowerSnakeCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("lower_snake_case", "lower_snake_case".toLowerSnakeCase()) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("lower_snake_case", "LOWER_SNAKE_CASE".toLowerSnakeCase()) {
            "a string that is all upper is properly converted to lower"
        }

        listOf(' ', '-', '|').forEach { sep ->
            assertEquals("lower_snake_case", "lower${sep}snake${sep}case".toLowerSnakeCase()) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("__uni_code__", "©®UNI¤CODE®©".toLowerSnakeCase()) {
            "Unicode characters are replaced"
        }

        assertEquals("dot.separated.string", "dot.separated.string".toLowerSnakeCase('.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("a.b-c|d", "a.b-c|d".toLowerSnakeCase('.', '-', '|')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("weir_dl_y_mi_xed_ca_sing", "WeirDlY_MiXed_CaSing".toLowerSnakeCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toUpperCaseFormat() {
        assertEquals("", "".toUpperCaseFormat('|')) {
            "empty strings are returned as-is"
        }

        assertEquals("UPPER|CASE|FORMAT", "UPPER|CASE|FORMAT".toUpperCaseFormat('|')) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("UPPER|CASE|FORMAT", "upper|case|format".toUpperCaseFormat('|')) {
            "a string that is all lower is properly converted to upper"
        }

        assertEquals("UPPER|CASE|FORMAT", "UpperCaseFormat".toUpperCaseFormat('|')) {
            "ASCII upper letters A..Z are word separators"
        }

        listOf(' ', '-', '_').forEach { sep ->
            assertEquals("UPPER|CASE|FORMAT", "upper${sep}case${sep}format".toUpperCaseFormat('|')) {
                "every symbol outside ASCII numbers 0..9 and lower letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("||UNI|CODE||", "©®UNI¤CODE®©".toUpperCaseFormat('|')) {
            "Unicode characters are replaced"
        }

        assertEquals("DOT.SEPARATED.STRING", "dot.separated.string".toUpperCaseFormat('|', '.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("A.B-C_D", "a.b-c_d".toUpperCaseFormat('|', '.', '-', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("WEIR|DL|Y|MI|XED|CA|SING", "WeirDlY-MiXed_CaSing".toUpperCaseFormat('|')) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toUpperDashCase() {
        assertEquals("", "".toUpperDashCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("UPPER-DASH-CASE", "UPPER-DASH-CASE".toUpperDashCase()) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("UPPER-DASH-CASE", "upper-dash-case".toUpperDashCase()) {
            "a string that is all lower is properly converted to upper"
        }

        listOf(' ', '|', '_').forEach { sep ->
            assertEquals("UPPER-DASH-CASE", "upper${sep}dash${sep}case".toUpperDashCase()) {
                "every symbol outside ASCII numbers 0..9 and upper letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("--UNI-CODE--", "©®UNI¤CODE®©".toUpperDashCase()) {
            "Unicode characters are replaced"
        }

        assertEquals("DOT.SEPARATED.STRING", "dot.separated.string".toUpperDashCase('.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("A.B|C_D", "a.b|c_d".toUpperDashCase('.', '|', '_')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("WEIR-DL-Y-MI-XED-CA-SING", "WeirDlY-MiXed_CaSing".toUpperDashCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }

    @Test
    fun toUpperSnakeCase() {
        assertEquals("", "".toUpperSnakeCase()) {
            "empty strings are returned as-is"
        }

        assertEquals("UPPER_SNAKE_CASE", "UPPER_SNAKE_CASE".toUpperSnakeCase()) {
            "a string that is already in its desired form is unchanged"
        }

        assertEquals("UPPER_SNAKE_CASE", "upper_snake_case".toUpperSnakeCase()) {
            "a string that is all lower is properly converted to upper"
        }

        listOf(' ', '-', '|').forEach { sep ->
            assertEquals("UPPER_SNAKE_CASE", "upper${sep}snake${sep}case".toUpperSnakeCase()) {
                "every symbol outside ASCII numbers 0..9 and upper letters a..z is a word separator (`$sep`)"
            }
        }

        assertEquals("__UNI_CODE__", "©®UNI¤CODE®©".toUpperSnakeCase()) {
            "Unicode characters are replaced"
        }

        assertEquals("DOT.SEPARATED.STRING", "dot.separated.string".toUpperSnakeCase('.')) {
            "ignored characters are included in the result verbatim"
        }

        assertEquals("A.B-C|D", "a.b-c|d".toUpperSnakeCase('.', '-', '|')) {
            "it is possible to ignore multiple characters"
        }

        assertEquals("WEIR_DL_Y_MI_XED_CA_SING", "WeirDlY_MiXed_CaSing".toUpperSnakeCase()) {
            "weirdly case formatted strings will lead to weird results"
        }
    }
}
