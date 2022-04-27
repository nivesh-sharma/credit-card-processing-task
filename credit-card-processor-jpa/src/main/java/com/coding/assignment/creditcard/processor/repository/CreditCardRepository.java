package com.coding.assignment.creditcard.processor.repository;

import com.coding.assignment.creditcard.processor.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
