package com.coding.assignment.creditcard.processor.rest;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import com.coding.assignment.creditcard.processor.repository.CreditCardRepository;
import com.coding.assignment.creditcard.processor.util.CheckLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(value = "/api/v1/creditCards")
@RestController
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCreditCard(@RequestBody CreditCard creditCard) {
        if (CheckLuhn.checkLuhn(creditCard.getCardNumber())) {
            try {
                creditCardRepository.save(creditCard);
                return new ResponseEntity<Object>(HttpStatus.OK);
            } catch (DuplicateKeyException e) {
                return new ResponseEntity<Error>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<Error>(HttpStatus.FORBIDDEN);
    }

}
