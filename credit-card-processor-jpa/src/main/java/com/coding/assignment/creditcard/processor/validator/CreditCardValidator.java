package com.coding.assignment.creditcard.processor.validator;

import java.util.Arrays;

/**
 * Luhn 10 Algorithm Implementation.
 *
 * @author Nivesh Sharma.
 */
public class CreditCardValidator {

    /**
     * Check whether supplied Credit number is valid or not, using Luhn 10 Algorithm.
     *
     * @param cardNumber Credit Card Number.
     * @return True or False.
     */
    public static boolean checkLuhn(String cardNumber) {

        // remove "-" from card number to blank
        cardNumber = cardNumber.replaceAll("[-]\\s", "");
        {
            // Create int array for processing the cardNumber
            int[] cardNumberArray = new int[cardNumber.length()];

            //Load array with card number digits
            for (int i = 0; i < cardNumber.length(); i++) {
                char c = cardNumber.charAt(i);
                cardNumberArray[i] = Integer.parseInt("" + c);
            }

            for (int j = cardNumberArray.length - 2; j >= 0; j = j - 2) {
                int num = cardNumberArray[j];
                num = num * 2;  // Step 1 – Starting from the rightmost digit, double the value of every second digit,
                if (num > 9) {  // If doubling of a number results in a two digit number i.e greater than 9
                    num = num % 10 + num / 10;  // Step 2 - Then add the digits of the product, to get a single digit number
                }
                cardNumberArray[j] = num;
            }

            int sum = sumDigits(cardNumberArray);  // Step 3 - Now take the sum of all the digits

            if (sum % 10 == 0)  // Step 4 - If the total mod 10 is equal to 0 then the number is valid according to the Luhn formula; else it is not valid.
            {
                return true;
            }
            return false;
        }
    }

    /**
     * Return Sum of digits in integer array.
     *
     * @param arr Integer Array.
     * @return sum of digits.
     */
    public static int sumDigits(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
