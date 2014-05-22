package org.training.nikitha.softwarerefactoring.chapter1.after;

/**
 * Created with IntelliJ IDEA.
 * User: rkonda
 * Date: 5/21/14
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }
}
