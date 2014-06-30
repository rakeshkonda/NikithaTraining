package assignment5;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class Customer {
    private PersonDescription personDescription;
    private Statement statement = new Statement(this);
    private ShoppingCart shoppingCart = new ShoppingCart();
    private RentalHistory rentalHistory = new RentalHistory();

    public Customer(PersonDescription personDescription) {
        this.personDescription = personDescription;
    }

    public Vector get_rentals() {
        return shoppingCart.get_rentals();
    }

    public void addRental(Rental arg) {
        shoppingCart.addRental(arg);
        rentalHistory.addToRentalHistory(arg);
    }

    public String getName() {
        return personDescription.getFullName();
    }

    public String statement() {
        //add footer lines
        return statement.statement();
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = shoppingCart.get_rentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = shoppingCart.get_rentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public Rental searchRentals(String movieTitle) throws Exception {
        Enumeration rentals = shoppingCart.get_rentals().elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            if(rental.getMovie().getTitle().equalsIgnoreCase(movieTitle)){
                return rental;
            }
        }
        throw new Exception("Rental for movie: "+movieTitle+" not found under this customers rental");
    }

    public PersonDescription getPersonDescription() {
        return personDescription;
    }

    public Statement getStatement() {
        return statement;
    }

    public RentalHistory getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(RentalHistory rentalHistory) {
        this.rentalHistory = rentalHistory;
    }
}
