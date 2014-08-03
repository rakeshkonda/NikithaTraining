package com.masters.oops;

/**
 * @author nikithaperumalla.
 * @id 87312
 */
public class CallingCard extends Card {

    private int cardNumber;
    private int pin;

    public CallingCard(String n, int cardNumber, int pin) {
        super(n);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String format() {
        return super.format() + ". Calling Card Number: "+this.cardNumber+". PIN: "+this.pin;
    }
}
