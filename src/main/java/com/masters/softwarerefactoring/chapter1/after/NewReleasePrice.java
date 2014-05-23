package com.masters.softwarerefactoring.chapter1.after;

/**
 * Created by nikithaperumalla on 5/21/14.
 */
public class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2: 1;
    }
}