package com.qa.zone24x7;

import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringOperations {

    /**
     * Reverses the input string
     * @param input string to reverse
     * @return reversed string
     */
    public String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return StringUtils.reverse(input);
    }

    /**
     * Checks if the string contains only alphabetic characters
     * @param input string to check
     * @return true if string is alphabetic
     */
    public boolean isAlphabetic(String input) {
        if (input == null) {
            return false;
        }
        return StringUtils.isAlpha(input);
    }

    /**
     * Capitalizes first letter of each word in the string
     * @param input string to capitalize
     * @return capitalized string
     */
    public String capitalizeWords(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return StringUtils.capitalize(input);
    }

    /**
     * Removes all whitespace from the string
     * @param input string to process
     * @return string without whitespace
     */
    public String removeWhitespace(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return StringUtils.deleteWhitespace(input);
    }
}