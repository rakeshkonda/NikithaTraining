package com.masters.oops;

/**
 * @author nikithaperumalla.
 * @id 87312
 */
public class IDCard extends Card {

    private int idNumber;

    public IDCard(String n, int idNumber) {
        super(n);
        this.idNumber = idNumber;
    }

    public String format() {
        return super.format() + ". ID Number: "+this.idNumber;
    }

}
