package assignment5;


/**
 * @author nikithaperumalla
 * @id 87312
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;
    private int _daysKept = 0; //would be set later when customer returns it.

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
        return _movie.getRentalCategory().RentalCharge() + _movie.getRentalCategory().getLateCharge(_daysKept);
    }

    public int getFrequentRenterPoints() {
        return _movie.getRentalCategory().getFrequentRenterPoints();
    }

    public int getDaysKept() {
        if(_daysKept == 0){
            //if this is zero, that means it is not modified/not rented for more than intended i.e. pay for daysRented
            return _daysRented;
        }
        return _daysKept;
    }

    public void setDaysKept(int daysKept) {
        this._daysKept = daysKept;
    }
}
