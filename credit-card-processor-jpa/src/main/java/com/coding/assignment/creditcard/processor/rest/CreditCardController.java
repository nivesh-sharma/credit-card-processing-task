package com.coding.assignment.creditcard.processor.rest;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import com.coding.assignment.creditcard.processor.repository.CreditCardRepository;
import com.coding.assignment.creditcard.processor.validator.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Specifies API's to Perform Credit Card Related Read and Add operations.
 *
 * @author Nivesh Sharma
 */
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/creditCards")
@RestController
public class CreditCardController {

    /**
     * Inject Credit Card Repository/DAO.
     */
    @Autowired
    private CreditCardRepository creditCardRepository;

    /**
     * Rest API to Get List of all Credit Card Details.
     * @return List of Credit Card Details.
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    /**
     * Rest API to Add Credit Card Details in DB repository.
     *
     * @param creditCard Credit Details.
     * @return HTTP Status 200 (OK), Conflict (409), FORBIDDEN(403)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCreditCard(@RequestBody CreditCard creditCard) {
        if (CreditCardValidator.checkLuhn(creditCard.getCardNumber())) {
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
