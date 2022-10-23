package com.fleshgrinder.kotlin;

/**
 * Dealing with high performance low level stuff is not easy in Kotlin because
 * of all the magic that is performed by Kotlin while compiling to JVM bytecode.
 * Hence, we fall back to using good old Java to do the plumbing.
 */
final class CaseFormat {
    static boolean isCamelCase(CharSequence input, char[] ignored, boolean upper) {
        return false;
    }

    static boolean isCaseFormat(CharSequence input, char separator, char[] ignored, boolean upper) {
        return false;
    }

    static String toCamelCase(CharSequence input, char[] ignored, boolean upper) {
        final int len = input.length();
        return appendCamelCase(new StringBuilder(len), input, len, ignored, upper).toString();
    }

    static String toCaseFormat(CharSequence input, char separator, char[] ignored, boolean upper) {
        final int len = input.length();
        return appendCaseFormat(new StringBuilder(len), input, len, separator, ignored, upper).toString();
    }

    static <T extends Appendable> T appendCamelCase(T receiver, CharSequence input, char[] ignored, boolean upper) {
        return appendCamelCase(receiver, input, input.length(), ignored, upper);
    }

    static <T extends Appendable> T appendCaseFormat(T receiver, CharSequence input, char separator, char[] ignored, boolean upper) {
        return appendCaseFormat(receiver, input, input.length(), separator, ignored, upper);
    }

    private static <T extends Appendable> T appendCamelCase(T receiver, CharSequence input, int len, char[] ignored, boolean upper) {
        return receiver;
    }

    private static <T extends Appendable> T appendCaseFormat(T receiver, CharSequence input, int len, char separator, char[] ignored, boolean upper) {
        return receiver;
    }
}
