package com.coding.assignment.creditcard.processor.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a credit card model.
 *
 * @author Nivesh Sharma
 */
@Data
@Entity
@Table(name = "CreditCard")
public class CreditCard {

    /**
     * The Customer Name.
     */
    @Column(nullable = false)
    private String customerName;

    /**
     * The Credit Card Number.
     */
    @Column(nullable = false, length = 19)
    @Id
    private String cardNumber;

    /**
     * Credit Card Limit.
     */
    @Column(nullable = false)
    private int cardLimit;

    /**
     * Credit Card Balance.
     */
    @Column(nullable = false)
    private int cardBalance;

    /**
     * Default Constructor.
     */
    public CreditCard() {
        super();
    }

    /**
     * Credit Card Details Constructor.
     *
     * @param customerName Customer Name.
     * @param cardNumber   Card Number.
     * @param cardLimit    Card Limit.
     * @param cardBalance  Card Balance.
     */
    public CreditCard(String customerName, String cardNumber, int cardLimit, int cardBalance) {
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.cardLimit = cardLimit;
        this.cardBalance = cardBalance;
    }
}

