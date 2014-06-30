package assignment5;


import java.util.Vector;

public class RentalHistory {
    private Vector<Rental> rentalHistory = new Vector<>();

    public RentalHistory(){
    }

    public Vector<Rental> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(Vector<Rental> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public void addToRentalHistory(Rental rental){
        this.getRentalHistory().add(rental);
    }

    public void addAllToRentalHistory(Vector<Rental> rentals){
        this.getRentalHistory().addAll(rentals);
    }
}
