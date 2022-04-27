package com.coding.assignment.creditcard.processor.validator;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardValidatorTest {

    @Test
    public void testLuhn10Algorithm() {
        String cardNumber = "5115007248020311";
        CreditCard creditCard = new CreditCard("Johny Correct", cardNumber, 100, 0);
        assertTrue(CreditCardValidator.checkLuhn(cardNumber));

        String invalidCardNumber = "9876543210235689";
        CreditCard invalidCreditCard = new CreditCard("Paul Wrong", invalidCardNumber, 100, 0);
        assertFalse(CreditCardValidator.checkLuhn(invalidCardNumber));
    }
}
