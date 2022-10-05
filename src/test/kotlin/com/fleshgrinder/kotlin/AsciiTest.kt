// package com.fleshgrinder.kotlin
//
// import io.kotest.core.spec.style.StringSpec
// import io.kotest.matchers.comparables.shouldBeEqualComparingTo
// import io.kotest.property.Arb
// import io.kotest.property.arbitrary.char
// import io.kotest.property.checkAll
// import io.kotest.property.forAll
//
// class AsciiTest : StringSpec({
//     "isAsciiDigit returns true for all ASCII digit chars" {
//         forAll(Arb.char('0'..'9')) {
//             it.isAsciiDigit()
//         }
//     }
//
//     "isAsciiDigit returns false for all non US-ASCII digit chars" {
//         forAll(Arb.char('\u0000' until '0', ('9' + 1)..Char.MAX_VALUE)) {
//             !it.isAsciiDigit()
//         }
//     }
//
//     "isAsciiLower returns true for all US-ASCII lowercase chars" {
//         forAll(Arb.char('a'..'z')) {
//             it.isAsciiLower()
//         }
//     }
//
//     "isAsciiLower returns false for all non US-ASCII lowercase chars" {
//         forAll(Arb.char('\u0000' until 'a', ('z' + 1)..Char.MAX_VALUE)) {
//             !it.isAsciiLower()
//         }
//     }
//
//     "isAsciiUpper returns true for all US-ASCII uppercase chars" {
//         forAll(Arb.char('A'..'Z')) {
//             it.isAsciiUpper()
//         }
//     }
//
//     "isAsciiUpper returns false for all non US-ASCII uppercase chars" {
//         forAll(Arb.char('\u0000' until 'A', ('Z' + 1)..Char.MAX_VALUE)) {
//             !it.isAsciiUpper()
//         }
//     }
//
//     "toAsciiLower transforms all US-ASCII uppercase chars to lowercase" {
//         checkAll(Arb.char('A'..'Z')) {
//             it.toAsciiLower() shouldBeEqualComparingTo it.lowercaseChar()
//         }
//     }
//
//     "toAsciiLower leaves all non US-ASCII uppercase chars untouched" {
//         checkAll(Arb.char('\u0000' until 'A', ('Z' + 1)..Char.MAX_VALUE)) {
//             it.toAsciiLower() shouldBeEqualComparingTo it
//         }
//     }
//
//     "toAsciiUpper transforms all US-ASCII lowercase chars to uppercase" {
//         checkAll(Arb.char('a'..'z')) {
//             it.toAsciiUpper() shouldBeEqualComparingTo it.uppercaseChar()
//         }
//     }
//
//     "toAsciiUpper leaves all non US-ASCII lowercase chars untouched" {
//         checkAll(Arb.char('\u0000' until 'a', ('z' + 1)..Char.MAX_VALUE)) {
//             it.toAsciiUpper() shouldBeEqualComparingTo it
//         }
//     }
// })
