package com.masters.softwarerefactoring.chapter1.after;


/**
 * Created with IntelliJ IDEA.
 * User: rkonda
 * Date: 5/21/14
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
