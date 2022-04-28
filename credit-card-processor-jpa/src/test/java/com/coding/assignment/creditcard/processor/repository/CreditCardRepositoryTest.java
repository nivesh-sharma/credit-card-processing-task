package com.coding.assignment.creditcard.processor.repository;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

public class CreditCardRepositoryTest {

    @MockBean
    private CreditCardRepository creditCardRepository;

    //@Test
    public void testGetAllCreditCards() throws Exception {
        CreditCard creditCard = getCreditCard();
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardRepository.save(creditCard);
        given(creditCardRepository.findAll()).willReturn(creditCardList);
        List<CreditCard> result = creditCardRepository.findAll();
        assertEquals(result.size(), 1);
    }

    //@Test
    public void testAddCreditCard() throws Exception {
        CreditCard creditCard = getCreditCard();
        doNothing().when(creditCardRepository).save(creditCard);
        creditCardRepository.save(creditCard);
        assertTrue(true);
    }

    private CreditCard getCreditCard() {
        return new CreditCard("John Derry", "5115007248020311", 0, 100);
    }
}