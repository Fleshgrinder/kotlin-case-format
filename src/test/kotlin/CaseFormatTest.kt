package com.fleshgrinder.extensions.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CaseFormatTest {
    @ParameterizedTest
    @CsvSource(
        "lowerCamelCase, lowerCamelCase",
        "upperCamelCase, UpperCamelCase",

        "lowerDashCase, lower-dash-case",
        "upperDashCase, UPPER-DASH-CASE",
        "titleDashCase, Title-Dash-Case",
        "lowerMixedDashCase, lower-mixed-dashCase",
        "upperMixedDashCase, upper-mixed-DashCase",

        "lowerDotCase, lower.dot.case",
        "upperDotCase, UPPER.DOT.CASE",
        "titleDotCase, Title.Dot.Case",
        "lowerMixedDotCase, lower.mixed.dotCase",
        "upperMixedDotCase, upper.mixed.DotCase",

        "lowerSnakeCase, lower_snake_case",
        "upperSnakeCase, UPPER_SNAKE_CASE",
        "titleSnakeCase, Title_Snake_Case",
        "lowerMixedSnakeCase, lower_mixed_snakeCase",
        "upperMixedSnakeCase, upper_mixed_SnakeCase",

        "javaPropertiesFileLowerName, java.propertiesFile.lowerName",
        "javaPropertiesFileUpperName, java.propertiesFile.UpperName",

        "uniCode, ©®UNI¤CODE®©",
        "uniCode, ©®uni¤code®©"
    )
    fun toLowerCamelCase(expected: String, input: String) {
        assertEquals(expected, input.toLowerCamelCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "lower|camel|case, lowerCamelCase, |",
        "upper|camel|case, UpperCamelCase, |",

        "lower|dash|case, lower-dash-case, |",
        "upper|dash|case, UPPER-DASH-CASE, |",
        "title|dash|case, Title-Dash-Case, |",
        "lower|mixed|dash|case, lower-mixed-dashCase, |",
        "upper|mixed|dash|case, upper-mixed-DashCase, |",

        "lower|dot|case, lower.dot.case, |",
        "upper|dot|case, UPPER.DOT.CASE, |",
        "title|dot|case, Title.Dot.Case, |",
        "lower|mixed|dot|case, lower.mixed.dotCase, |",
        "upper|mixed|dot|case, upper.mixed.DotCase, |",

        "lower|snake|case, lower_snake_case, |",
        "upper|snake|case, UPPER_SNAKE_CASE, |",
        "title|snake|case, Title_Snake_Case, |",
        "lower|mixed|snake|case, lower_mixed_snakeCase, |",
        "upper|mixed|snake|case, upper_mixed_SnakeCase, |",

        "java|properties|file|lower|name, java.propertiesFile.lowerName, |",
        "java|properties|file|upper|name, java.propertiesFile.UpperName, |",

        "||uni|code||, ©®UNI¤CODE®©, |",
        "||uni|code||, ©®uni¤code®©, |"
    )
    fun toLowerCaseFormat(expected: String, input: String, separator: Char) {
        assertEquals(expected, input.toLowerCaseFormat(separator), input)
    }

    @ParameterizedTest
    @CsvSource(
        "lower-camel-case, lowerCamelCase",
        "upper-camel-case, UpperCamelCase",

        "lower-dash-case, lower-dash-case",
        "upper-dash-case, UPPER-DASH-CASE",
        "title-dash-case, Title-Dash-Case",
        "lower-mixed-dash-case, lower-mixed-dashCase",
        "upper-mixed-dash-case, upper-mixed-DashCase",

        "lower-dot-case, lower.dot.case",
        "upper-dot-case, UPPER.DOT.CASE",
        "title-dot-case, Title.Dot.Case",
        "lower-mixed-dot-case, lower.mixed.dotCase",
        "upper-mixed-dot-case, upper.mixed.DotCase",

        "lower-snake-case, lower_snake_case",
        "upper-snake-case, UPPER_SNAKE_CASE",
        "title-snake-case, Title_Snake_Case",
        "lower-mixed-snake-case, lower_mixed_snakeCase",
        "upper-mixed-snake-case, upper_mixed_SnakeCase",

        "java-properties-file-lower-name, java.propertiesFile.lowerName",
        "java-properties-file-upper-name, java.propertiesFile.UpperName",

        "--uni-code--, ©®UNI¤CODE®©",
        "--uni-code--, ©®uni¤code®©"
    )
    fun toLowerDashCase(expected: String, input: String) {
        assertEquals(expected, input.toLowerDashCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "lower.camel.case, lowerCamelCase",
        "upper.camel.case, UpperCamelCase",

        "lower.dash.case, lower-dash-case",
        "upper.dash.case, UPPER-DASH-CASE",
        "title.dash.case, Title-Dash-Case",
        "lower.mixed.dash.case, lower-mixed-dashCase",
        "upper.mixed.dash.case, upper-mixed-DashCase",

        "lower.dot.case, lower.dot.case",
        "upper.dot.case, UPPER.DOT.CASE",
        "title.dot.case, Title.Dot.Case",
        "lower.mixed.dot.case, lower.mixed.dotCase",
        "upper.mixed.dot.case, upper.mixed.DotCase",

        "lower.snake.case, lower_snake_case",
        "upper.snake.case, UPPER_SNAKE_CASE",
        "title.snake.case, Title_Snake_Case",
        "lower.mixed.snake.case, lower_mixed_snakeCase",
        "upper.mixed.snake.case, upper_mixed_SnakeCase",

        "java.properties.file.lower.name, java.propertiesFile.lowerName",
        "java.properties.file.upper.name, java.propertiesFile.UpperName",

        "..uni.code.., ©®UNI¤CODE®©",
        "..uni.code.., ©®uni¤code®©"
    )
    fun toLowerDotCase(expected: String, input: String) {
        assertEquals(expected, input.toLowerDotCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "lower_camel_case, lowerCamelCase",
        "upper_camel_case, UpperCamelCase",

        "lower_dash_case, lower-dash-case",
        "upper_dash_case, UPPER-DASH-CASE",
        "title_dash_case, Title-Dash-Case",
        "lower_mixed_dash_case, lower-mixed-dashCase",
        "upper_mixed_dash_case, upper-mixed-DashCase",

        "lower_dot_case, lower.dot.case",
        "upper_dot_case, UPPER.DOT.CASE",
        "title_dot_case, Title.Dot.Case",
        "lower_mixed_dot_case, lower.mixed.dotCase",
        "upper_mixed_dot_case, upper.mixed.DotCase",

        "lower_snake_case, lower_snake_case",
        "upper_snake_case, UPPER_SNAKE_CASE",
        "title_snake_case, Title_Snake_Case",
        "lower_mixed_snake_case, lower_mixed_snakeCase",
        "upper_mixed_snake_case, upper_mixed_SnakeCase",

        "java_properties_file_lower_name, java.propertiesFile.lowerName",
        "java_properties_file_upper_name, java.propertiesFile.UpperName",

        "__uni_code__, ©®UNI¤CODE®©",
        "__uni_code__, ©®uni¤code®©"
    )
    fun toLowerSnakeCase(expected: String, input: String) {
        assertEquals(expected, input.toLowerSnakeCase(), input)
    }
    @ParameterizedTest
    @CsvSource(
        "LowerCamelCase, lowerCamelCase",
        "UpperCamelCase, UpperCamelCase",

        "LowerDashCase, lower-dash-case",
        "UpperDashCase, UPPER-DASH-CASE",
        "TitleDashCase, Title-Dash-Case",
        "LowerMixedDashCase, lower-mixed-dashCase",
        "UpperMixedDashCase, upper-mixed-DashCase",

        "LowerDotCase, lower.dot.case",
        "UpperDotCase, UPPER.DOT.CASE",
        "TitleDotCase, Title.Dot.Case",
        "LowerMixedDotCase, lower.mixed.dotCase",
        "UpperMixedDotCase, upper.mixed.DotCase",

        "LowerSnakeCase, lower_snake_case",
        "UpperSnakeCase, UPPER_SNAKE_CASE",
        "TitleSnakeCase, Title_Snake_Case",
        "LowerMixedSnakeCase, lower_mixed_snakeCase",
        "UpperMixedSnakeCase, upper_mixed_SnakeCase",

        "JavaPropertiesFileLowerName, java.propertiesFile.lowerName",
        "JavaPropertiesFileUpperName, java.propertiesFile.UpperName",

        "UniCode, ©®UNI¤CODE®©",
        "UniCode, ©®uni¤code®©"
    )
    fun toUpperCamelCase(expected: String, input: String) {
        assertEquals(expected, input.toUpperCamelCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER|CAMEL|CASE, lowerCamelCase, |",
        "UPPER|CAMEL|CASE, UpperCamelCase, |",

        "LOWER|DASH|CASE, lower-dash-case, |",
        "UPPER|DASH|CASE, UPPER-DASH-CASE, |",
        "TITLE|DASH|CASE, Title-Dash-Case, |",
        "LOWER|MIXED|DASH|CASE, lower-mixed-dashCase, |",
        "UPPER|MIXED|DASH|CASE, upper-mixed-DashCase, |",

        "LOWER|DOT|CASE, lower.dot.case, |",
        "UPPER|DOT|CASE, UPPER.DOT.CASE, |",
        "TITLE|DOT|CASE, Title.Dot.Case, |",
        "LOWER|MIXED|DOT|CASE, lower.mixed.dotCase, |",
        "UPPER|MIXED|DOT|CASE, upper.mixed.DotCase, |",

        "LOWER|SNAKE|CASE, lower_snake_case, |",
        "UPPER|SNAKE|CASE, UPPER_SNAKE_CASE, |",
        "TITLE|SNAKE|CASE, Title_Snake_Case, |",
        "LOWER|MIXED|SNAKE|CASE, lower_mixed_snakeCase, |",
        "UPPER|MIXED|SNAKE|CASE, upper_mixed_SnakeCase, |",

        "JAVA|PROPERTIES|FILE|LOWER|NAME, java.propertiesFile.lowerName, |",
        "JAVA|PROPERTIES|FILE|UPPER|NAME, java.propertiesFile.UpperName, |",

        "||UNI|CODE||, ©®UNI¤CODE®©, |",
        "||UNI|CODE||, ©®uni¤code®©, |"
    )
    fun toUpperCaseFormat(expected: String, input: String, separator: Char) {
        assertEquals(expected, input.toUpperCaseFormat(separator), input)
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER-CAMEL-CASE, lowerCamelCase",
        "UPPER-CAMEL-CASE, UpperCamelCase",

        "LOWER-DASH-CASE, lower-dash-case",
        "UPPER-DASH-CASE, UPPER-DASH-CASE",
        "TITLE-DASH-CASE, Title-Dash-Case",
        "LOWER-MIXED-DASH-CASE, lower-mixed-dashCase",
        "UPPER-MIXED-DASH-CASE, upper-mixed-DashCase",

        "LOWER-DOT-CASE, lower.dot.case",
        "UPPER-DOT-CASE, UPPER.DOT.CASE",
        "TITLE-DOT-CASE, Title.Dot.Case",
        "LOWER-MIXED-DOT-CASE, lower.mixed.dotCase",
        "UPPER-MIXED-DOT-CASE, upper.mixed.DotCase",

        "LOWER-SNAKE-CASE, lower_snake_case",
        "UPPER-SNAKE-CASE, UPPER_SNAKE_CASE",
        "TITLE-SNAKE-CASE, Title_Snake_Case",
        "LOWER-MIXED-SNAKE-CASE, lower_mixed_snakeCase",
        "UPPER-MIXED-SNAKE-CASE, upper_mixed_SnakeCase",

        "JAVA-PROPERTIES-FILE-LOWER-NAME, java.propertiesFile.lowerName",
        "JAVA-PROPERTIES-FILE-UPPER-NAME, java.propertiesFile.UpperName",

        "--UNI-CODE--, ©®UNI¤CODE®©",
        "--UNI-CODE--, ©®uni¤code®©"
    )
    fun toUpperDashCase(expected: String, input: String) {
        assertEquals(expected, input.toUpperDashCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER.CAMEL.CASE, lowerCamelCase",
        "UPPER.CAMEL.CASE, UpperCamelCase",

        "LOWER.DASH.CASE, lower-dash-case",
        "UPPER.DASH.CASE, UPPER-DASH-CASE",
        "TITLE.DASH.CASE, Title-Dash-Case",
        "LOWER.MIXED.DASH.CASE, lower-mixed-dashCase",
        "UPPER.MIXED.DASH.CASE, upper-mixed-DashCase",

        "LOWER.DOT.CASE, lower.dot.case",
        "UPPER.DOT.CASE, UPPER.DOT.CASE",
        "TITLE.DOT.CASE, Title.Dot.Case",
        "LOWER.MIXED.DOT.CASE, lower.mixed.dotCase",
        "UPPER.MIXED.DOT.CASE, upper.mixed.DotCase",

        "LOWER.SNAKE.CASE, lower_snake_case",
        "UPPER.SNAKE.CASE, UPPER_SNAKE_CASE",
        "TITLE.SNAKE.CASE, Title_Snake_Case",
        "LOWER.MIXED.SNAKE.CASE, lower_mixed_snakeCase",
        "UPPER.MIXED.SNAKE.CASE, upper_mixed_SnakeCase",

        "JAVA.PROPERTIES.FILE.LOWER.NAME, java.propertiesFile.lowerName",
        "JAVA.PROPERTIES.FILE.UPPER.NAME, java.propertiesFile.UpperName",

        "..UNI.CODE.., ©®UNI¤CODE®©",
        "..UNI.CODE.., ©®uni¤code®©"
    )
    fun toUpperDotCase(expected: String, input: String) {
        assertEquals(expected, input.toUpperDotCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "LOWER_CAMEL_CASE, lowerCamelCase",
        "UPPER_CAMEL_CASE, UpperCamelCase",

        "LOWER_DASH_CASE, lower-dash-case",
        "UPPER_DASH_CASE, UPPER-DASH-CASE",
        "TITLE_DASH_CASE, Title-Dash-Case",
        "LOWER_MIXED_DASH_CASE, lower-mixed-dashCase",
        "UPPER_MIXED_DASH_CASE, upper-mixed-DashCase",

        "LOWER_DOT_CASE, lower.dot.case",
        "UPPER_DOT_CASE, UPPER.DOT.CASE",
        "TITLE_DOT_CASE, Title.Dot.Case",
        "LOWER_MIXED_DOT_CASE, lower.mixed.dotCase",
        "UPPER_MIXED_DOT_CASE, upper.mixed.DotCase",

        "LOWER_SNAKE_CASE, lower_snake_case",
        "UPPER_SNAKE_CASE, UPPER_SNAKE_CASE",
        "TITLE_SNAKE_CASE, Title_Snake_Case",
        "LOWER_MIXED_SNAKE_CASE, lower_mixed_snakeCase",
        "UPPER_MIXED_SNAKE_CASE, upper_mixed_SnakeCase",

        "JAVA_PROPERTIES_FILE_LOWER_NAME, java.propertiesFile.lowerName",
        "JAVA_PROPERTIES_FILE_UPPER_NAME, java.propertiesFile.UpperName",

        "__UNI_CODE__, ©®UNI¤CODE®©",
        "__UNI_CODE__, ©®uni¤code®©"
    )
    fun toUpperSnakeCase(expected: String, input: String) {
        assertEquals(expected, input.toUpperSnakeCase(), input)
    }

    @ParameterizedTest
    @CsvSource(
        "loremIpsum.dolorSit.amet.consecteturAdipiscing, lorem-ipsum.dolor-sit.amet.consectetur-adipiscing, .",
        "loremIpsum.dolorSit.amet.consecteturAdipiscing, lorem_ipsum.dolor_sit.amet.consectetur_adipiscing, .",
        "loremIpsum.dolorSit.amet.consecteturAdipiscing, LOREM-IPSUM.DOLOR-SIT.AMET.CONSECTETUR-ADIPISCING, .",
        "loremIpsum.dolorSit.amet.consecteturAdipiscing, LOREM_IPSUM.DOLOR_SIT.AMET.CONSECTETUR_ADIPISCING, ."
    )
    fun `ignored chars are included as is in result`(expected: String, input: String, ignore: Char) {
        assertEquals(expected, input.toLowerCamelCase(ignore), input)
    }
}
