@file:Suppress("NOTHING_TO_INLINE")

package com.fleshgrinder.caseFormat

internal inline fun Char.isAsciiDigit(): Boolean =
    this in '0'..'9'

internal inline fun Char.isAsciiUpper(): Boolean =
    this in 'A'..'Z'

internal inline fun Char.isAsciiLower(): Boolean =
    this in 'a'..'z'

internal inline fun Char.isAsciiLetter(): Boolean =
    isAsciiUpper() || isAsciiLower()

internal inline fun Char.isAsciiLetterOrDigit(): Boolean =
    isAsciiLetter() || isAsciiDigit()

internal inline fun Char.toAsciiLower(): Char =
    (code and 0x5F).toChar()

internal inline fun Char.toAsciiUpper(): Char =
    (code or 0x20).toChar()
