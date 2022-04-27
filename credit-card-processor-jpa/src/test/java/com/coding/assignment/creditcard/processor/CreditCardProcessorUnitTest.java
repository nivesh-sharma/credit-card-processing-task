package com.coding.assignment.creditcard.processor;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import com.coding.assignment.creditcard.processor.repository.CreditCardRepository;
import org.springframework.boot.test.mock.mockito.MockBean;

public class CreditCardProcessorUnitTest {

    @MockBean
    private CreditCardRepository creditCardRepository;

    public void testGetAllCreditCards() throws exception {


    }

    private CreditCard getCreditCard() {
        return new CreditCard("John Doe", "5343175202483207", 0, 100);
    }

}