package assignment4;


/**
 * @author nikithaperumalla
 * @id 87312
 */
public class Movie {
    //Rental Category added after refactoring
    private RentalCategory _rentalCategory;
    private String _title;

    public Movie(String title, RentalCategory rentalCategory) {
        _title = title;
        _rentalCategory = rentalCategory;
    }

    public String getTitle() {
        return _title;
    }

    public RentalCategory getRentalCategory() {
        return _rentalCategory;
    }

    public void setRentalCategory(RentalCategory rentalCategory) {
        this._rentalCategory = rentalCategory;
    }
}
