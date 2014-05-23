package com.masters.softwarerefactoring.chapter1.after;

/**
 * Created by nikithaperumalla on 5/21/14.
 */
public class RegularPrice extends Price {
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
