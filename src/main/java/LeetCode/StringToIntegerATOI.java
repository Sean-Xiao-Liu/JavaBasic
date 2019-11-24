package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerATOI {
    public int myAtoi(String str) {
        boolean isNonWhitespaceCharacterExpected = false, isPositiveNumber = true;
        int number = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                isNonWhitespaceCharacterExpected = true;
                final int digit = str.charAt(i) - '0';
                if ((Integer.MAX_VALUE - digit) / 10 < number) {
                    return isPositiveNumber ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number *= 10;
                number += digit;
            } else if (!isNonWhitespaceCharacterExpected && str.charAt(i) == '+') {
                isNonWhitespaceCharacterExpected = true;
                isPositiveNumber = true;
            } else if (!isNonWhitespaceCharacterExpected && str.charAt(i) == '-') {
                isNonWhitespaceCharacterExpected = true;
                isPositiveNumber = false;
            } else if (isNonWhitespaceCharacterExpected || str.charAt(i) != ' ') {
                break;
            }
        }

        return isPositiveNumber ? number : -number;
    }

    public static void main(String[] args) {
    }
}
