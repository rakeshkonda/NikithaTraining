package com.masters.softwarerefactoring.chapter1.after;

/**
 * Created by nikithaperumalla on 5/21/14.
 */
public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
