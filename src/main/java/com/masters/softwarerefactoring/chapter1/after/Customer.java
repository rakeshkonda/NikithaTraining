package org.training.nikitha.softwarerefactoring.chapter1.after;

import org.training.nikitha.softwarerefactoring.chapter1.after.Movie;
import org.training.nikitha.softwarerefactoring.chapter1.after.Rental;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: rkonda
 * Date: 5/21/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(org.training.nikitha.softwarerefactoring.chapter1.before.Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            //TODO Refactor 1 : moved code to amountFor method
            //thisAmount = amountFor(each); //TODO removed because of refactor 3

            //thisAmount = each.getCharge(); //TODO Refactor 4: redundant in last line of while loop

            // add frequent renter points
            //TODO Refactor 5: moved code to getFrequentRenterPoints in rental class
            //frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) +
                    "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for each rental
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    @Deprecated
    private double amountFor(Rental aRental) {
        //TODO Refactor 2 : moved getCharge method to Rental as it uses only rental data and doesnot use any of customers data
        return aRental.getCharge(); //TODO Refactor 3 : not needed here, we can directly access from rrental object
    }
}
