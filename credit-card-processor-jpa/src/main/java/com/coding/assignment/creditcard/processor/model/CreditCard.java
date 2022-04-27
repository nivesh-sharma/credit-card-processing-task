package com.coding.assignment.creditcard.processor.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CreditCard")
public class CreditCard {

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false, length = 19)
    @Id
    private String cardNumber;

    @Column(nullable = false)
    private int cardLimit;

    @Column(nullable = false)
    private int cardBalance;

    /**
     * Default Constructor.
     */
    public CreditCard() {
        super();
    }

    /**
     * Credit Card Constructor.
     *
     * @param customerName
     * @param cardNumber
     * @param cardLimit
     * @param cardBalance
     */
    public CreditCard(String customerName, String cardNumber, int cardLimit, int cardBalance) {
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.cardLimit = cardLimit;
        this.cardBalance = cardBalance;
    }

}

