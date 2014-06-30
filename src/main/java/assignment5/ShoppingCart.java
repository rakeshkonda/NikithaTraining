package assignment5;

import java.util.Vector;

public class ShoppingCart {
    Vector _rentals = new Vector();

    public ShoppingCart() {
    }

    public Vector get_rentals() {
        return _rentals;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
}