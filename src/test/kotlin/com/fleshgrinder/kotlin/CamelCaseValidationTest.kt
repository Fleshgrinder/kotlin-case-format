package com.fleshgrinder.kotlin

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

private const val D1 = '.'
private const val D2 = '-'

private class CamelCaseValidationTest {
    private val String.m0 get() = "\"$this\".isLowerCamelCase()"
    private val String.m1 get() = "\"$this\".isLowerCamelCase('$D1')"
    private val String.m2 get() = "\"$this\".isLowerCamelCase('$D1', '$D2')"

    private fun String.f0() = assertFalse(isLowerCamelCase(), m0)
    private fun String.f1() = assertFalse(isLowerCamelCase(D1), m1)
    private fun String.f2() = assertFalse(isLowerCamelCase(D1, D2), m2)

    private fun String.s0() = assertTrue(isLowerCamelCase(), m0)
    private fun String.s1() = assertTrue(isLowerCamelCase(D1), m1)
    private fun String.s2() = assertTrue(isLowerCamelCase(D1, D2), m2)

    @Nested inner class InvalidAll {
        private operator fun String.invoke() = assertAll({ f0() }, { f1() }, { f2() })

        @Test fun empty() = ""()

        @Test fun d1() = "$D1"()
        @Test fun d2() = "$D2"()
        @Test fun blank() = " "()
        @Test fun upper() = "A"()
        @Test fun digit() = "0"()
        @Test fun `min(lower)-1`() = "${'a' - 1}"()
        @Test fun `max(lower)+1`() = "${'z' + 1}"()

        @Test fun `d1 d1`() = "$D1$D1"()
        @Test fun `d1 d2`() = "$D1$D2"()
        @Test fun `d2 d2`() = "$D2$D2"()
        @Test fun `d2 d1`() = "$D2$D1"()
        @Test fun `lower d1`() = "a$D1"()
        @Test fun `lower d2`() = "a$D2"()
        @Test fun `lower blank`() = "a "()
        @Test fun `lower min(digit)-1`() = "a${'0' - 1}"()
        @Test fun `lower max(digit)+1`() = "a${'9' + 1}"()
        @Test fun `lower min(lower)-1`() = "a${'a' - 1}"()
        @Test fun `lower max(lower)+1`() = "a${'z' + 1}"()
        @Test fun `lower min(upper)-1`() = "a${'A' - 1}"()
        @Test fun `lower max(upper)+1`() = "a${'Z' + 1}"()
        @Test fun `blank lower`() = " a"()
        @Test fun `digit lower`() = "0a"()
        @Test fun `upper lower`() = "Aa"()

        @Test fun `lower upper upper`() = "aAA"()
        @Test fun `lower digit upper upper`() = "a0AA"()
        @Test fun `lower lower upper upper`() = "aaAA"()

        @Test fun `a@`() = "a@"()
        @Test fun `a@@`() = "a@@"()
        @Test fun `a@@@`() = "a@@@"()
        @Test fun `aa@`() = "aa@"()
        @Test fun `aa@@`() = "aa@@"()
        @Test fun `aa@@@`() = "aa@@@"()
        @Test fun `aaa@`() = "aaa@"()
        @Test fun `aaa@@`() = "aaa@@"()
        @Test fun `aaa@@@`() = "aaa@@@"()

        @Test fun `lower d1 d1`() = "a$D1$D1"()
        @Test fun `lower d1 d2`() = "a$D1$D2"()
        @Test fun `lower d2 d1`() = "a$D2$D1"()
        @Test fun `lower d2 d2`() = "a$D2$D2"()

        @Test fun aAAA() = "aAAA"()
        @Test fun toUUID() = "toUUID"()
        @Test fun toXMLNode() = "toXMLNode"()

        // TODO ????
        //@Test fun nIO() = "nIO"()
    }

    @Nested inner class InvalidDelimiter {
        private operator fun String.invoke() = assertAll({ f1() }, { f2() })

        @Test fun `d1 lower`() = ".a"()
        @Test fun `lower d1`() = "a."()
        @Test fun `lower d1 digit`() = "a.0"()
        @Test fun `lower d1 upper`() = "a.A"()
        @Test fun `lower d1 d1 lower`() = "a..a"()
        @Test fun `lower d1 upper upper`() = "a.AA"()
    }

    @Nested inner class InvalidDelimiters {
        private operator fun String.invoke() = f2()

        @Test fun `d2 lower`() = "-a"()
        @Test fun `lower d2`() = "a-"()
        @Test fun `lower d1 d2`() = "a.-"()
        @Test fun `lower d2 d1`() = "a-."()
        @Test fun `lower d2 upper`() = "a-A"()
        @Test fun `lower d2 digit`() = "a-0"()
    }

    @Nested inner class ValidAll {
        private operator fun String.invoke() = assertAll({ s0() }, { s1() }, { s2() })

        @Test fun lower() = "a"()
        @Test fun `lower lower`() = "aa"()
        @Test fun `lower upper`() = "aA"()
        @Test fun `lower digit`() = "a0"()

        @Test fun `lower lower lower`() = "aaa"()

        @Test fun `lower upper lower`() = "aAa"()
        @Test fun `lower lower upper`() = "aaA"()

        @Test fun `lower digit lower`() = "a0a"()
        @Test fun `lower digit digit`() = "a00"()
        @Test fun `lower lower digit`() = "aa0"()

        @Test fun `lower upper upper lower`() = "aAAa"()
        @Test fun `lower upper lower upper`() = "aAaA"()

        @Test fun `lower digit digit lower`() = "a00a"()
        @Test fun `lower lower digit digit`() = "aa00"()
        @Test fun `lower digit lower digit`() = "a0a0"()
        @Test fun `lower digit digit digit`() = "a000"()

        @Test fun `lower upper digit upper`() = "aA0A"()
        @Test fun `lower upper upper digit`() = "aAA0"()

        @Test fun toUuid() = "toUuid"()
        @Test fun toXmlNode() = "toXmlNode"()
        @Test fun nonlinearXWave() = "nonlinearXWave"()
    }

    @Nested inner class ValidDelimiter {
        private operator fun String.invoke() = assertAll({ s1() }, { s2() })

        @Test fun `lower d1 lower`() = "a${D1}a"()
        @Test fun `lower upper d1 lower upper`() = "aA${D1}aA"()
        @Test fun `lower digit d1 lower digit`() = "a0${D1}a0"()
        @Test fun `lower upper d1 lower digit`() = "aA${D1}a0"()
        @Test fun `lower digit d1 lower upper`() = "a0${D1}aA"()
        @Test fun `lower upper digit d1 lower upper digit`() = "aA0${D1}aA0"()
        @Test fun `lower d1 lower d1 lower`() = "a${D1}a${D1}a"()

        @Test fun `fooBar d1 baz`() = "fooBar${D1}baz"()
        @Test fun `foo d1 barBaz`() = "foo${D1}barBaz"()
        @Test fun `foo d1 bar d1 baz`() = "foo${D1}bar${D1}baz"()
        @Test fun `fooBar d1 fooBar d1 fooBar`() = "fooBar${D1}fooBar${D1}fooBar"()
    }
}
