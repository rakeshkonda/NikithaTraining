package assignment5;

import java.util.Enumeration;

public class Statement {
    private final Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }

    public String statement() {
        Enumeration rentals = customer.get_rentals().elements();
        String result = "Rental Record for " + customer.getPersonDescription().getFullName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) +
                    "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = customer.get_rentals().elements();
        String result = "<H1>Rentals for <EM>" + customer.getPersonDescription().getFullName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for each rental
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(customer.getTotalCharge()) +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(customer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    public Customer getCustomer() {
        return customer;
    }
}