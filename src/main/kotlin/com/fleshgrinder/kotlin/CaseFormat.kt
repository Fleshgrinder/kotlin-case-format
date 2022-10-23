package com.fleshgrinder.kotlin

// TODO isJavaProperty toJavaProperty ????

public fun CharSequence.isLowerCamelCase(vararg ignore: Char): Boolean = CaseFormat.isCamelCase(this, ignore, false)
public fun CharSequence.isUpperCamelCase(vararg ignore: Char): Boolean = CaseFormat.isCamelCase(this, ignore, true)
public fun CharSequence.isLowerKebabCase(vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, '-', ignore, false)
public fun CharSequence.isUpperKebabCase(vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, '-', ignore, true)
public fun CharSequence.isLowerSnakeCase(vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, '_', ignore, false)
public fun CharSequence.isUpperSnakeCase(vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, '_', ignore, true)
public fun CharSequence.isLowerCaseFormat(separator: Char, vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, separator, ignore, false)
public fun CharSequence.isUpperCaseFormat(separator: Char, vararg ignore: Char): Boolean = CaseFormat.isCaseFormat(this, separator, ignore, true)

public fun CharSequence.toLowerCamelCase(vararg ignore: Char): String = CaseFormat.toCamelCase(this, ignore, false)
public fun CharSequence.toUpperCamelCase(vararg ignore: Char): String = CaseFormat.toCamelCase(this, ignore, true)
public fun CharSequence.toLowerKebabCase(vararg ignore: Char): String = CaseFormat.toCaseFormat(this, '-', ignore, false)
public fun CharSequence.toUpperKebabCase(vararg ignore: Char): String = CaseFormat.toCaseFormat(this, '-', ignore, true)
public fun CharSequence.toLowerSnakeCase(vararg ignore: Char): String = CaseFormat.toCaseFormat(this, '_', ignore, false)
public fun CharSequence.toUpperSnakeCase(vararg ignore: Char): String = CaseFormat.toCaseFormat(this, '_', ignore, true)
public fun CharSequence.toLowerCaseFormat(separator: Char, vararg ignore: Char): String = CaseFormat.toCaseFormat(this, separator, ignore, false)
public fun CharSequence.toUpperCaseFormat(separator: Char, vararg ignore: Char): String = CaseFormat.toCaseFormat(this, separator, ignore, true)

public fun <T : Appendable> T.appendLowerCamelCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCamelCase(this, input, ignore, false)
public fun <T : Appendable> T.appendUpperCamelCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCamelCase(this, input, ignore, true)
public fun <T : Appendable> T.appendLowerKebabCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, '-', ignore, false)
public fun <T : Appendable> T.appendUpperKebabCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, '-', ignore, true)
public fun <T : Appendable> T.appendLowerSnakeCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, '_', ignore, false)
public fun <T : Appendable> T.appendUpperSnakeCase(input: CharSequence, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, '_', ignore, true)
public fun <T : Appendable> T.appendLowerCaseFormat(input: CharSequence, separator: Char, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, separator, ignore, false)
public fun <T : Appendable> T.appendUpperCaseFormat(input: CharSequence, separator: Char, vararg ignore: Char): T = CaseFormat.appendCaseFormat(this, input, separator, ignore, false)
